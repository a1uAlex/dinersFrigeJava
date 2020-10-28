package de.alex.dinersFrige.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class InhaltDTO {

    Long id;

    Long artikelId;

    Date mhd;

    Double menge;  //TODO gegebenenfalls zu Integer ändern
}
