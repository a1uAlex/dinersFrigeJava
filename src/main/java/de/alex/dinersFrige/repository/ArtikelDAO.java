package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelDAO extends JpaRepository<Artikel, Long> {
    void deleteById(Long id);
}
