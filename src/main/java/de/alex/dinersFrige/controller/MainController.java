package de.alex.dinersFrige.controller;

import de.alex.dinersFrige.models.Artikel;
import de.alex.dinersFrige.models.Inhalt;
import de.alex.dinersFrige.models.Kategorie;
import de.alex.dinersFrige.repository.ArtikelDAO;
import de.alex.dinersFrige.repository.InhaltDAO;
import de.alex.dinersFrige.repository.KategorieDAO;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("message", "Dies ist ein Test!");
        return "main";
    }

    @GetMapping("content")
    public String content(Model model){
        List<Inhalt> inhaltList= inhaltDAO.findAll();
        model.addAttribute(inhaltList);
        return "content";
    }

    @GetMapping("manageCategory")
    public String manageCategory(Model model){
        List<Kategorie> kategorieList = kategorieDAO.findAll();
        model.addAttribute(kategorieList);
        return "manageCategory";
    }

    @DeleteMapping("category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable (value = "id") String id){
        try{
            Long longId = Long.valueOf(id);
            kategorieDAO.deleteById(longId);
            kategorieDAO.flush();
        } catch (NumberFormatException e){
        }
        return;
    }

    @PostMapping("category")
    public String addCategory(@ModelAttribute Kategorie kategorie){
        kategorieDAO.saveAndFlush(kategorie);
        return "redirect:/manageCategory";
    }

    @GetMapping("addCategory")
    public String addCategoryPage(Model model){
        model.addAttribute("kategorie", new Kategorie());
        return "addCategory";
    }

    @DeleteMapping("/article")
    public String deleteArticle(Model model, @RequestParam Long id){
        artikelDAO.deleteById(id);
        //TODO HIER die richtige Seite einfügen!
        return manageCategory(model);
    }


}
