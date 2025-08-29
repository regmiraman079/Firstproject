package myFirstProject.raman.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artistId;
    private String url;
    private int height;
    private int width;

    public ImageEntity() {}
    public ImageEntity(String artistId, String url, int height, int width) {
        this.artistId = artistId;
        this.url = url;
        this.height = height;
        this.width = width;
    }
}