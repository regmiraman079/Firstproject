package myFirstProject.raman.controller;

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


    @PostMapping("/spotify2")
    public int searchArtist() {
        return addition.add(5, 10);
    }

    @PostMapping("/artist")
    public Map<String, Object> getArtist(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return spotifyService.searchArtistByName(name);
    }
}
