package de.alex.dinersFrige.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.alex.dinersFrige.models.Rezept;


import javax.xml.catalog.CatalogFeatures;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonToDB {

    public static void main(String[] args) throws Exception{

        List<Rezept> rezeptList = new ArrayList<Rezept>();
        String jsonDir = "C:/Users/alexa/Desktop/rezepte";

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

        System.out.println(rezeptList.get(800));


    }
}
