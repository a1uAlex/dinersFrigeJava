package de.alex.dinersFrige.models;

import javax.persistence.Id;
import java.net.URL;

public class Kategorie {

    @Id
    Long id;

    String name;

    String bild;
}
