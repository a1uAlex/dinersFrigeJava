package de.alex.dinersFrige.converter;

import de.alex.dinersFrige.DTO.InhaltDTO;
import de.alex.dinersFrige.models.Artikel;
import de.alex.dinersFrige.models.Inhalt;
import de.alex.dinersFrige.repository.ArtikelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Service
public class InhaltConverter {

    @Autowired
    ArtikelDAO artikelDAO;

    public Inhalt toInhalt(InhaltDTO inhaltDTO) {

        Inhalt inhalt = new Inhalt();
        Artikel artikel = artikelDAO.findById(inhaltDTO.getArtikelId()).orElseThrow(() -> new EntityNotFoundException());
        inhalt.setArtikel(artikel);
        inhalt.setMenge(inhaltDTO.getMenge());
        if(inhaltDTO.getMhd().length()>0){
            String datum = inhaltDTO.getMhd();

            int year = Integer.parseInt(datum.substring(0, 3));
            int month = Integer.parseInt(datum.substring(5, 6));
            int day = Integer.parseInt(datum.substring(8, 9));

            Calendar calendar = new GregorianCalendar();
            calendar.set(year, month, day);
            inhalt.setMhd(calendar.getTime());
        } else {
            inhalt.setMhd(null);
        }

        return inhalt;
    }

}
