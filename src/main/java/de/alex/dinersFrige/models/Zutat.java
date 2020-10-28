package de.alex.dinersFrige.models;

import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Zutat {

    public Zutat(String zutat){
        this.zutat = zutat;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String zutat;
}
