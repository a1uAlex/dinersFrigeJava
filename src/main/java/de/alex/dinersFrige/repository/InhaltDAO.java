package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Inhalt;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InhaltDAO extends JpaRepository<Inhalt, Long> {

    List<Inhalt> findAll();

}
