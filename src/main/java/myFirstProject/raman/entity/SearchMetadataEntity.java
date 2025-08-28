package myFirstProject.raman.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "search_metadata")
public class SearchMetadataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
}

