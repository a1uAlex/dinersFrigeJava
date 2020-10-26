package de.alex.dinersFrige.DTO;

import de.alex.dinersFrige.models.Kategorie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class ArtikelDTO {

    Long id;

    String name;

    Long kategorieId;

    String bild;

    String einheit;

    String isShortcut;

}
