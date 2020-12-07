package com.Webalkalmaz.sTask.Gpnwzt.controller;

import java.io.IOException;

import com.Webalkalmaz.sTask.Gpnwzt.models.Product;
import com.Webalkalmaz.sTask.Gpnwzt.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/prodindex")
    public String index(Model model) throws IOException {
        model.addAttribute("list", productService.findAll());
        return "prodindex";
    }

    @GetMapping("/prodform={ID}")
    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            model.addAttribute("product", productService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {

        }
        return "prodform";

    }

    @GetMapping("/prodform")
    public String formInsert(Model model) throws IOException {
        model.addAttribute("product", new Product());
        return "prodform";
    }

    @PostMapping("/produpdate")
    public String formSubmit(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productService.save(product);
        return "prodproceeded";
    }

    @GetMapping("/proddelete={ID}")
    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            productService.delete(productService.findById(longid));
        } catch (NumberFormatException e) {

        }
        return "prodproceeded";

    }
}

