package myFirstProject.raman.dao;

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


@Component
public class dataInterpolater {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private SearchMetadataRepository metadataRepository;

    public void saveSpotifyData(SpotifyResponse response) {
        // Save metadata
        SearchMetadataEntity metadata = new SearchMetadataEntity();
        metadata.setHref(response.getArtists().getHref());
        metadata.setLimit_value(response.getArtists().getLimit_value());
        metadata.setNext(response.getArtists().getNext());
        metadata.setOffset_value(response.getArtists().getOffset_value());
        metadata.setPrevious(response.getArtists().getPrevious());
        metadata.setTotal(response.getArtists().getTotal());
        metadataRepository.save(metadata);

        // Save artists
        for (ArtistItem item : response.getArtists().getItems()) {
            ArtistEntity artist = new ArtistEntity();
            artist.setId(item.getId());
            artist.setName(item.getName());
            artist.setHref(item.getHref());
            artist.setSpotifyUrl(item.getExternal_urls().get("spotify"));
            artist.setFollowers(item.getFollowers().getTotal());
            artist.setPopularity(item.getPopularity());
            artist.setType(item.getType());
            artist.setUri(item.getUri());
            artistRepository.save(artist);

            // Save genres
            for (String genre : item.getGenres()) {
                genreRepository.save(new GenreEntity(artist.getId(), genre));
            }

            // Save images
            for (Image img : item.getImages()) {
                imageRepository.save(new ImageEntity(artist.getId(), img.getUrl(), img.getHeight(), img.getWidth()));
            }
        }
    }
}
