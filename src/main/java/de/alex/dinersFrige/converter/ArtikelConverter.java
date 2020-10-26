package de.alex.dinersFrige.converter;

import de.alex.dinersFrige.DTO.ArtikelDTO;
import de.alex.dinersFrige.models.Artikel;
import de.alex.dinersFrige.models.Kategorie;
import de.alex.dinersFrige.repository.ArtikelDAO;
import de.alex.dinersFrige.repository.KategorieDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Setter
@Getter
@NoArgsConstructor
public class ArtikelConverter {

    @Autowired
    KategorieDAO kategorieDAO;

    public Artikel toArtikel(ArtikelDTO artikelDTO){
        Artikel artikel = new Artikel();

        artikel.setBild(artikelDTO.getBild());
        artikel.setEinheit(artikelDTO.getEinheit());
        artikel.setName(artikelDTO.getName());
        System.out.println(artikelDTO.getIsShortcut());
        if(artikelDTO.getIsShortcut() != null){
            artikel.setIsShortcut(true);
        } else {
            artikel.setIsShortcut(false);
        }

        Kategorie kategorie = kategorieDAO.findById(artikelDTO.getKategorieId()).orElseThrow(() -> new EntityNotFoundException());
        artikel.setKategorie(kategorie);

        return artikel;
    }
}
