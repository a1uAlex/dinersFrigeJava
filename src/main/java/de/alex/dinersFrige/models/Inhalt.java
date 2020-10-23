package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Inhalt {

    @Id
    Long id;

    //Kategorie kategorie

    Date mhd;

    Double menge;


}
