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
public class Zutat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

    Double menge;
}
