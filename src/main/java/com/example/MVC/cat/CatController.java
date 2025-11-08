package com.example.MVC.Cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class CatController{

    @Autowired
    private CatService catService;

    @GetMapping("/cats/{id}")
    public String getCatById(@PathVariable Long id, Model model){
        model.addAttribute("cat", catService.getCatById(id));
        model.addAttribute("title", "Cat #: " + id);
        return "cat-details";
    }

    @GetMapping("/cats/name")
    public Object getCatsByName(@RequestParam String key, Model model){
        if(key != null){
            model.addAttribute("cat-list", catService.getCatsByName(key));
            model.addAttribute("title", "Cats with name: " + key);
            return "cat-list";
        }else{
            return "redirect:/cats/";
        }
      
    }

    @GetMapping("/cats/sex")
    public Object getCatsBySex(@RequestParam String sex, Model model){
        model.addAttribute("cat-list", catService.getCatsBySex(sex));
        model.addAttribute("title", "Cats by sex: " + sex);
        return "cat-list";
    }

    @GetMapping("/cats/breed")
    public Object getCatsByBreed(@RequestParam String key, Model model){
        model.addAttribute("cat-list", catService.getCatsByBreed(key));
        model.addAttribute("title", "Cats of breed: " + key);
        return "cat-list";
        
    }

    @GetMapping("/cats/createForm")
    public Object showCreateForm(Model model){
        Cat cat  = new Cat();
        model.addAttribute("cat", cat);
        model.addAttribute("title", "Add New Cat");
        return "cat-create";
    }

    @PostMapping("/cats")
    public Object addCat(Cat cat, @RequestParam MultipartFile catImg){
        catService.addCat(cat, catImg);
        return catService.addCat(cat, catImg);
    }

    @PutMapping("/cats/{id}")
    public Object updateCat(@PathVariable Long id, Cat cat, @RequestParam MultipartFile catImg){
        catService.updateCat(id, cat, catImg);
        return "redirect:/cats/" + id;
    }

    @GetMapping("/cats/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model){
        Cat cat = catService.getCatById(id);
        model.addAttribute("cat", cat);
        model.addAttribute("title", "Update Cat #: " + id);
        return "cat-update";
    }

    @DeleteMapping("/cats/delete/{id}")
    public Object deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
        return "redirect:/cats/";
    }


}