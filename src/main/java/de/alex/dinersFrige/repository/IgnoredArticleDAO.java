package de.alex.dinersFrige.repository;

import de.alex.dinersFrige.models.IgnoredArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IgnoredArticleDAO extends JpaRepository<IgnoredArticle, Long> {
}
