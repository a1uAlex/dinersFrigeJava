package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordDAO extends JpaRepository<Keyword, Long> {
}
