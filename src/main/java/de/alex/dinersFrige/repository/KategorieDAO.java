package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorieDAO extends JpaRepository<Kategorie, Long> {

}
