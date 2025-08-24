package myFirstProject.raman.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ArtistDataResponse {
    private String artistName;
    private Map<String, Object> data; // e.g., {"albums": [...], "songs": [...]}
}