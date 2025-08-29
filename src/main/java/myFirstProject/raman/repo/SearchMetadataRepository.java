package myFirstProject.raman.repo;

import myFirstProject.raman.entity.SearchMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchMetadataRepository extends JpaRepository<SearchMetadataEntity, Long> {
}
