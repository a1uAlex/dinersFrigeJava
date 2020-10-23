package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Inhalt {

    @Id
    Long id;

    @ManyToOne
    Artikel artikel;

    Date mhd;


}
