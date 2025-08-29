package myFirstProject.raman.service;

import myFirstProject.raman.DTO.*;
import myFirstProject.raman.connector.SpotifyConnector;
import myFirstProject.raman.entity.ArtistEntity;
import myFirstProject.raman.entity.GenreEntity;
import myFirstProject.raman.entity.ImageEntity;
import myFirstProject.raman.entity.SearchMetadataEntity;
import myFirstProject.raman.repo.ArtistRepository;
import myFirstProject.raman.repo.GenreRepository;
import myFirstProject.raman.repo.ImageRepository;
import myFirstProject.raman.repo.SearchMetadataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SpotifyServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private SearchMetadataRepository metadataRepository;

    @Mock
    private SpotifyConnector spotifyConnector;

    @InjectMocks
    private SpotifyService spotifyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testSearchArtistByName() {
        Map<String, Object> mockResult = Map.of("artists", "dummy");
        when(spotifyConnector.searchArtist("Adele", 1)).thenReturn(mockResult);

        Map<String, Object> result = spotifyService.searchArtistByName("Adele");


        verify(spotifyConnector, times(1)).searchArtist("Adele", 1);

        assert(result.get("artists").equals("dummy"));
    }
}