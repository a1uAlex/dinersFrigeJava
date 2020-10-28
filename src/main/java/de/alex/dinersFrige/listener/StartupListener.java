package de.alex.dinersFrige.listener;

import de.alex.dinersFrige.services.JsonToDbService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value( "${rezept.buildDB}" )
    private Boolean buildDB;

    @Value( "${rezept.path}" )
    private String path;

    @Autowired
    JsonToDbService jsonToDbService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(buildDB){
            jsonToDbService.addToDB(path);
        }
    }
}
