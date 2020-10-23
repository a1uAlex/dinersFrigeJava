package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Kategorie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

    String bild;

}
