package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.net.URL;
import java.sql.Array;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rezept {

    @Id
    Long id;

    Boolean istFavorit;

    String titel;

    @OneToMany
    List <Zutat> zutaten;

    String beschreibung;

    Integer vZeit;

    Integer kZeit;

    String kategorie;

    String bild;

    Double bewertung;

    @ManyToMany
    List<Keyword> keywords;

    String ernaehrungsweise;

}
