package myFirstProject.raman.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artistId;
    private String genre;

    public GenreEntity() {}
    public GenreEntity(String artistId, String genre) {
        this.artistId = artistId;
        this.genre = genre;
    }
}
