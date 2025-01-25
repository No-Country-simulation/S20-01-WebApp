/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.controller.postgres;
package com.nutriwise.nutriwise.entity.Receta;
package com.nutriwise.nutriwise.logica.RecetaServices;

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
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaServices recetaService;

    @PostMapping
    public ResponseEntity<?> crearReceta(@RequestBody Receta receta) {
        try {
            if (receta.getNombre() == null || receta.getNombre().isEmpty()) {
                return new ResponseEntity<>("El nombre de la receta es obligatorio.", HttpStatus.BAD_REQUEST);
            }
            if (receta.getDescripcion() == null || receta.getDescripcion().isEmpty()) {
                return new ResponseEntity<>("La descripción es obligatoria.", HttpStatus.BAD_REQUEST);
            }
            Receta nuevaReceta = recetaService.crearReceta(receta);
            return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la receta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllRecetas() {
        try {
            List<Receta> recetas = recetaService.getAllRecetas();
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las recetas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
