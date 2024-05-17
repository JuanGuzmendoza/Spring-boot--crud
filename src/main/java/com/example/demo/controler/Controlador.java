package com.example.demo.controler;
import java.util.*;
import com.example.demo.modelo.Persona;
import com.example.demo.service.PersonaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.interfaces.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
@RequestMapping
public class Controlador {
	
    @Autowired
	private IPersona data;
    private  PersonaService service;

    public Controlador(PersonaService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<Persona> personas = service.Listar();
        if (personas == null) {
            personas = new ArrayList<>();
        }
        model.addAttribute("personas", personas);
        return "blog";
    }

    @GetMapping("/prueba")
    public String prueba(Model model) {
    	List<Persona>a=(List<Persona>)data.findAll();
        model.addAttribute("personas", a);
    	return "blog";
    }
    @GetMapping("/new")
    public String agregar(Model modelo) {
    	modelo.addAttribute("persona",new Persona());
    	return "formulario";
    }
    @PostMapping("/save")
    public String save(@Validated Persona p,Model model) {
    	service.save(p);
    	System.out.print(p);
    	return"redirect:/lista";
    }
}
