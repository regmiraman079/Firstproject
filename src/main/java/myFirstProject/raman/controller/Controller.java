package myFirstProject.raman.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import myFirstProject.raman.DTO.SpotifyResponse;
import myFirstProject.raman.service.Addition;
import myFirstProject.raman.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/spotify")
public class Controller {
    @Autowired
    Addition addition;

    @Autowired
    SpotifyService spotifyService;


    @PostMapping("/artist")
    public Map<String, Object> searchAndSaveArtist(@RequestBody Map<String, String> request) {
        String name = request.get("name");

        // Search artist
        Map<String, Object> artistData = spotifyService.searchArtistByName(name);

        // Convert Map to SpotifyResponse
        ObjectMapper mapper = new ObjectMapper();
        SpotifyResponse response = mapper.convertValue(artistData, SpotifyResponse.class);

        // Save the data
        spotifyService.saveSpotifyData(response);

        return spotifyService.searchArtistByName(name);
    }
}
