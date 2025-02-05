/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.controller;

import com.nutriwise02.receta.spring.nutriwise02.receta.dto.MenuNutri02RequestDTO;
import com.nutriwise02.receta.spring.nutriwise02.receta.dto.MenuNutri02ResponseDTO;
import com.nutriwise02.receta.spring.nutriwise02.receta.entity.Menu;
import com.nutriwise02.receta.spring.nutriwise02.receta.repository.MenuNutri02Repository;
import com.nutriwise02.receta.spring.nutriwise02.receta.service.GeminiNutri02Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Elsa
 */

@RestController
@RequestMapping("/api/menus")
public class MenuNutri02Controller {

    @Autowired
    private MenuNutri02Repository menuRepository;

    @Autowired
    private GeminiNutri02Service geminiService;

    @PostMapping("/recetas")
    public ResponseEntity<MenuNutri02ResponseDTO> obtenerRecetas(@RequestBody MenuNutri02RequestDTO request) {
      
        if (request.getTipoComida() == null || request.getTipoDieta() == null) {
            return ResponseEntity.badRequest().body(new MenuNutri02ResponseDTO(List.of("Los campos 'tipoComida' y 'tipoDieta' son obligatorios")));
        }

        
        String receta = geminiService.getReceta(request.getTipoComida(), request.getTipoDieta());

        
        if (receta == null || receta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MenuNutri02ResponseDTO(List.of("No se pudo generar la receta")));
        }

       
        Menu menu = new Menu();
        menu.setTipocomida(request.getTipoComida());
        menu.setTipodieta(request.getTipoDieta());
        menu.setReceta(receta);

        menuRepository.save(menu);

        return ResponseEntity.ok(new MenuNutri02ResponseDTO(List.of(receta)));
    }
    
     
    @GetMapping
    public ResponseEntity<List<Menu>> obtenerTodasLasRecetas() {
        List<Menu> recetas = menuRepository.findAll();
        if (recetas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(recetas);
        }
        return ResponseEntity.ok(recetas);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Menu> obtenerRecetaPorId(@PathVariable Integer id) {
        Optional<Menu> receta = menuRepository.findById(id);
        return receta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
