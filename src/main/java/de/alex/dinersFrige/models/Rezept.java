package de.alex.dinersFrige.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.sql.Array;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
@ToString
@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    Boolean istFavorit;

    String titel;

    @OneToMany
    List <Zutat> zutaten;

    @Column(length = 99999)
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
