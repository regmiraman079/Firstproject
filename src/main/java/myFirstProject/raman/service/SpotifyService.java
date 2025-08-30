package myFirstProject.raman.service;

import myFirstProject.raman.DTO.ArtistItem;
import myFirstProject.raman.DTO.Image;
import myFirstProject.raman.DTO.SpotifyResponse;
import myFirstProject.raman.connector.SpotifyConnector;
import myFirstProject.raman.entity.ArtistEntity;
import myFirstProject.raman.entity.GenreEntity;
import myFirstProject.raman.entity.ImageEntity;
import myFirstProject.raman.entity.SearchMetadataEntity;
import myFirstProject.raman.repo.ArtistRepository;
import myFirstProject.raman.repo.GenreRepository;
import myFirstProject.raman.repo.ImageRepository;
import myFirstProject.raman.repo.SearchMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
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
