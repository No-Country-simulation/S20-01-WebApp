/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.logica;

package com.nutriwise.nutriwise.entity.Receta;
package com.nutriwise.nutriwise.interfaz.postgres.RecetaRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elsa
 */

@Service
public class RecetaServices {

    @Autowired
    private RecetaRepository recetaRepository;

    public Receta crearReceta(Receta receta) {
        if (receta.getNombre() == null || receta.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la receta es obligatorio.");
        }
        if (receta.getDescripcion() == null || receta.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }
        return recetaRepository.save(receta);
    }

    public List<Receta> getAllRecetas() {
        return recetaRepository.findAll();
    }
}