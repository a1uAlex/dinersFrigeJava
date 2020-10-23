package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KategorieDAO extends JpaRepository<Kategorie, Long> {

    List<Kategorie> findAll();

    void deleteById(Long id);

}
