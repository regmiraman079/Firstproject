package myFirstProject.raman.service;

import myFirstProject.raman.connector.SpotifyConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Component
public class SpotifyService {
    @Autowired
    SpotifyConnector spotifyConnector;

    public SpotifyService(SpotifyConnector spotifyConnector) {
        this.spotifyConnector = spotifyConnector;
    }

    public Map<String, Object> searchArtistByName(String name) {
        return spotifyConnector.searchArtist(name, 1);
    }
}
