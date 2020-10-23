package de.alex.dinersFrige.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Artikel {

    @Id
    Long id;

    String name;

    @ManyToOne
    Kategorie kategorie;

    String bild;

    String einheit;

    Integer menge;

}