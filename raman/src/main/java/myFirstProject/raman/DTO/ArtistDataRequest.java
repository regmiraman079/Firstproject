package myFirstProject.raman.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtistDataRequest {
    private String name;               // artist name
    private List<String> dataRequested; // e.g., ["albums", "songs"]
}
