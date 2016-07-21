package com.zzheads.giflib.controller;

import com.zzheads.giflib.data.CategoryRepository;
import com.zzheads.giflib.data.GifRepository;
import com.zzheads.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;
    private CategoryRepository categoryRepository;

    @RequestMapping ("/")
    public String listGifs (ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping ("/gif/{name}")
    public String gifDetails (@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping ("/categories")
    public String listCategories (ModelMap modelMap) {
        modelMap.put("categories", gifRepository.getAllCategories());
        return "categories";
    }

    @RequestMapping ("/category/{id}")
    public String gifsByCategory (@PathVariable int id, ModelMap modelMap) {
        List<Gif> gifs = gifRepository.findByCategory(id);
        modelMap.put("gifs", gifs);
        modelMap.put("category", categoryRepository.getCategory(id));
        return "category";
    }

    @RequestMapping ("/favorites")
    public String listFavorites (ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.findFavorites());
        return "favorites";
    }

}
