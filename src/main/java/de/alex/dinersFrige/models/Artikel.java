package de.alex.dinersFrige.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

    @ManyToOne
    Kategorie kategorie;

    String bild;

    String einheit;

    Boolean isShortcut;

}