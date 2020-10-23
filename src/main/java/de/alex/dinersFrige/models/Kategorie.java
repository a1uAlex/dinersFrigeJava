package de.alex.dinersFrige.models;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.URL;
import java.util.Set;

public class Kategorie {

    @Id
    Long id;

    String name;

    String bild;

    @OneToMany (mappedBy = "artikel")
    Set<Artikel> artikelSet;
}
