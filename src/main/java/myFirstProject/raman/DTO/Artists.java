package myFirstProject.raman.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artists {
    private String href;
    private int limit_value;
    private String next;
    private int offset_value;
    private String previous;
    private int total;
    private List<ArtistItem> items;
}

