package de.alex.dinersFrige.controller;

import de.alex.dinersFrige.models.Artikel;
import de.alex.dinersFrige.models.Inhalt;
import de.alex.dinersFrige.models.Kategorie;
import de.alex.dinersFrige.repository.ArtikelDAO;
import de.alex.dinersFrige.repository.InhaltDAO;
import de.alex.dinersFrige.repository.KategorieDAO;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    InhaltDAO inhaltDAO;

    @Autowired
    KategorieDAO kategorieDAO;

    @Autowired
    ArtikelDAO artikelDAO;

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

    @RequestMapping(value = "/manageCategory", method = RequestMethod.GET)
    public String manageCategory(Model model){
        List<Kategorie> kategorieList = kategorieDAO.findAll();
        model.addAttribute(kategorieList);
        return "manageCategory";
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public String deleteCategory(Model model, @RequestParam Long id){
        kategorieDAO.deleteById(id);
        List<Kategorie> kategorieList = kategorieDAO.findAll();
        model.addAttribute(kategorieList);
        return "manageCategory";
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String addCategory(Model model, @ModelAttribute Kategorie kategorie){
        kategorieDAO.saveAndFlush(kategorie);
        return manageCategory(model);
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String addCategoryPage(Model model){
        model.addAttribute("kategorie", new Kategorie());
        return "addCategory";
    }

    @RequestMapping(value = "/article", method = RequestMethod.DELETE)
    public String deleteArticle(Model model, @RequestParam Long id){
        artikelDAO.deleteById(id);
        //TODO HIER die richtige Seite einfügen!
        return manageCategory(model);
    }


}
