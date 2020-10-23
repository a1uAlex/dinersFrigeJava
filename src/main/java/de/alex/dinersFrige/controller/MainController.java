package de.alex.dinersFrige.controller;

import de.alex.dinersFrige.models.Inhalt;
import de.alex.dinersFrige.repository.InhaltDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    InhaltDAO inhaltDAO;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String mainPage(Model model){
        model.addAttribute("message", "Dies ist ein Test!");
        return "main";
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String content(Model model){
        List<Inhalt> inhaltList= inhaltDAO.findAll();
        model.addAttribute(inhaltList);
        return "content";
    }


}
