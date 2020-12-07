package com.Webalkalmaz.sTask.Gpnwzt.controller;

import java.io.IOException;

import com.Webalkalmaz.sTask.Gpnwzt.models.Factory;
import com.Webalkalmaz.sTask.Gpnwzt.service.FactoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @GetMapping("/index")
    public String index(Model model) throws IOException {
        model.addAttribute("list", factoryService.findAll());
        return "index";
    }

    @GetMapping("/form={ID}")
    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            model.addAttribute("factory", factoryService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {

        }
        return "form";

    }

    @GetMapping("/form")
    public String formInsert(Model model) throws IOException {
        model.addAttribute("factory", new Factory());
        return "form";
    }

    @PostMapping("/update")
    public String formSubmit(@ModelAttribute Factory factory, Model model) {
        model.addAttribute("factory", factory);
        factoryService.save(factory);
        return "proceeded";
    }

    @GetMapping("/delete={ID}")
    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            factoryService.delete(factoryService.findById(longid));
        } catch (NumberFormatException e) {

        }
        return "proceeded";

    }
}
