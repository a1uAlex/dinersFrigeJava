package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Rezept;
import de.alex.dinersFrige.models.Zutat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZutatDAO extends JpaRepository<Zutat, Long> {
}
