package de.alex.dinersFrige.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @JoinColumn(name="kategorie_fk")
    Kategorie kategorie;

    String bild;

    String einheit;

    Boolean isShortcut;

    @OneToMany(mappedBy = "artikel")
    List<Inhalt> inhalte;

}