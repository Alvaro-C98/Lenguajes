package com.mvc.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.lenguajes.models.Leng;
import com.mvc.lenguajes.services.LengService;

import jakarta.validation.Valid;

@Controller
public class LengController {

	@Autowired
	private LengService lengService;
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/lenguage";
	}
	
	@GetMapping("/lenguage")
    public String index(Model model) {
        List<Leng> lengs = lengService.allLengs();
        model.addAttribute("lengs", lengs);
        return "lenguage/index.jsp";
    }
	
    @GetMapping("/lenguage/new")
    public String newLeng(@ModelAttribute("leng") Leng leng) {
        return "lenguage/new.jsp";
    }
	
    @PostMapping(value="/lenguage")
    public String create(@Valid @ModelAttribute("leng") Leng leng, BindingResult result) {
        if (result.hasErrors()) {
            return "/lenguage/new.jsp";
        } else {
            lengService.createLeng(leng);
            return "redirect:/lenguage";
        }
    }
    
  
    @GetMapping("/lenguage/{id}")
    public String show(@PathVariable("id") Long id,
    		Model model) {
    	Leng leng = lengService.findLeng(id);
    	model.addAttribute("leng",leng);
    	return "lenguage/show.jsp";
    }
    
    @GetMapping("/lenguage/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Leng leng = lengService.findLeng(id);
        model.addAttribute("leng", leng);
        return "lenguage/edit.jsp";
    }
    
    @PutMapping(value="/lenguage/{id}")
    public String update(@Valid @ModelAttribute("leng") Leng leng, BindingResult result) {
        if (result.hasErrors()) {
            return "lenguage/edit.jsp";
        } else {
            lengService.update(leng);
            return "redirect:/lenguage";
        }
    }
    
    @DeleteMapping(value="/lenguage/{id}")
    public String destroy(@PathVariable("id") Long id) {
        lengService.delete(id);
        return "redirect:/lenguage";
    }
	
	
}
