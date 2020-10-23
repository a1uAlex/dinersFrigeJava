package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Rezept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezeptDAO extends JpaRepository<Rezept, Long> {

}
