package de.alex.dinersFrige.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InhaltDTO {

    Long id;

    Long artikelId;

    String mhd;

    Double menge;
}
