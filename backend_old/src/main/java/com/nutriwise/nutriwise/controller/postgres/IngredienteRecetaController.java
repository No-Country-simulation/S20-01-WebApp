/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.controller.postgres;
package com.nutriwise.nutriwise.entity.IngredienteReceta;
package com.nutriwise.nutriwise.logica.IngredienteRecetaServices;

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
@RequestMapping("/api/ingredientes-recetas")
public class IngredienteRecetaController {

    @Autowired
    private IngredienteRecetaServices ingredienteRecetaService;

    @PostMapping
    public ResponseEntity<?> crearIngredienteReceta(@RequestBody IngredienteReceta ingredienteReceta) {
        try {
            if (ingredienteReceta.getIngrediente() == null || ingredienteReceta.getReceta() == null) {
                return new ResponseEntity<>("Ingrediente y receta son obligatorios.", HttpStatus.BAD_REQUEST);
            }
            if (ingredienteReceta.getCantidad() <= 0) {
                return new ResponseEntity<>("La cantidad debe ser mayor a 0.", HttpStatus.BAD_REQUEST);
            }
            IngredienteReceta nuevoIngredienteReceta = ingredienteRecetaService.crearIngredienteReceta(ingredienteReceta);
            return new ResponseEntity<>(nuevoIngredienteReceta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la entrada de ingrediente-receta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEntradas() {
        try {
            List<IngredienteReceta> valoresingredrecet = ingredienteRecetaService.getAllEntradas();
            return new ResponseEntity<>(valoresingredrecet, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las entradas de ingrediente-receta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
