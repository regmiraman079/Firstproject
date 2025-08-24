package myFirstProject.raman.connector;

import myFirstProject.raman.Configuration.SpotifyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Component
public class SpotifyConnector {

    @Autowired
    SpotifyConfig spotifyConfig;

    private final WebClient webClient;
    private String accessToken;

    public SpotifyConnector(WebClient.Builder webClientBuilder, SpotifyConfig spotifyConfig) {
        this.webClient = webClientBuilder.baseUrl("https://api.spotify.com/v1").build();
    }

    /** Authenticate with Spotify and get access token */
    public void authenticate() {
        String credentials = spotifyConfig.getClientId() + ":" + spotifyConfig.getClientSecret();
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        Map<String, String> response = WebClient.create()
                .post()
                .uri("https://accounts.spotify.com/api/token")
                .header("Authorization", "Basic " + encoded)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        this.accessToken = (String) response.get("access_token");
    }

    /** Search artist by name */
    public Map<String, Object> searchArtist(String name, int limit) {
        if (accessToken == null) {
            authenticate();
        }

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", name)
                        .queryParam("type", "artist")
                        .queryParam("limit", limit)
                        .build())
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
