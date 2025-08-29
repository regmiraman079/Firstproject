package myFirstProject.raman.repo;

import myFirstProject.raman.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, String> {

}


