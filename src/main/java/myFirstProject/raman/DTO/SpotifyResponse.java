package myFirstProject.raman.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SpotifyResponse {
    private Artists artists;
}