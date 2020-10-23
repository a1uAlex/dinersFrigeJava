package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.URL;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Kategorie {

    @Id
    Long id;

    String name;

    String bild;

    @OneToMany (mappedBy = "artikel")
    Set<Artikel> artikelSet;
}
