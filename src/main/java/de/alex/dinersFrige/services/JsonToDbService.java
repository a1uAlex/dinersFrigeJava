package de.alex.dinersFrige.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.alex.dinersFrige.models.Keyword;
import de.alex.dinersFrige.models.Rezept;
import de.alex.dinersFrige.models.Zutat;
import de.alex.dinersFrige.repository.KeywordDAO;
import de.alex.dinersFrige.repository.RezeptDAO;
import de.alex.dinersFrige.repository.ZutatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonToDbService {

    @Autowired
    RezeptDAO rezeptDAO;

    @Autowired
    ZutatDAO zutatDAO;

    @Autowired
    KeywordDAO keywordDAO;

    public void addToDB(String jsonDir) throws IOException {
        List<Rezept> rezeptList = new ArrayList<Rezept>();

        String[] pathnames;

        File f = new File(jsonDir);

        pathnames = f.list();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        int i = 0;
        for (String pathname : pathnames) {
            System.err.println(i);
            Rezept rezept = objectMapper.readValue(new File(jsonDir + "/" + pathname), Rezept.class);
            rezeptList.add(rezept);
            i++;
        }

        for(Rezept rezept: rezeptList){
            for (Keyword keyword: rezept.getKeywords()){
                keywordDAO.saveAndFlush(keyword);
            }

            for (Zutat zutat: rezept.getZutaten()){
                zutatDAO.saveAndFlush(zutat);
            }

            rezeptDAO.saveAndFlush(rezept);
        }

    }
}
