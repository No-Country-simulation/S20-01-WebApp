/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.controller.postgres;
package com.nutriwise.nutriwise.entity.Ingrediente;
package com.nutriwise.nutriwise.logica.IngredienteServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elsa
 */
   
@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteServices ingredienteService;

    @PostMapping
    public ResponseEntity<?> crearIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            if (ingrediente.getNombre() == null || ingrediente.getNombre().isEmpty()) {
                return new ResponseEntity<>("El nombre del ingrediente es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            Ingrediente nuevoIngrediente = ingredienteService.crearIngrediente(ingrediente);
            return new ResponseEntity<>(nuevoIngrediente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el ingrediente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllIngredientes() {
        try {
            List<Ingrediente> ingredientes = ingredienteService.getAllIngredientes();
            return new ResponseEntity<>(ingredientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener los ingredientes: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
