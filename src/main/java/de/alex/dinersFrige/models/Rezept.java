package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
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
