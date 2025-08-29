package myFirstProject.raman.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "artist")
public class ArtistEntity {
    @Id
    private String id;
    private String name;
    private String href;
    private String spotifyUrl;
    private int followers;
    private int popularity;
    private String type;
    private String uri;
}