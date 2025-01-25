/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.logica;

package com.nutriwise.nutriwise.entity.IngredienteReceta;
package com.nutriwise.nutriwise.interfaz.postgres.IngredienteRecetaRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elsa
 */

@Service
public class IngredienteRecetaServices {

    @Autowired
    private IngredienteRecetaRepository ingredienteRecetaRepository;

    public IngredienteReceta crearIngredienteReceta(IngredienteReceta ingredienteReceta) {
        if (ingredienteReceta.getIngrediente() == null || ingredienteReceta.getReceta() == null) {
            throw new IllegalArgumentException("Ingrediente y receta son obligatorios.");
        }
        if (ingredienteReceta.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
        if (ingredienteReceta.getUnidad() == null) {
            throw new IllegalArgumentException("La unidad es obligatoria");
        }
        return ingredienteRecetaRepository.save(ingredienteReceta);
    }

    public List<IngredienteReceta> getAllEntradas() {
        return ingredienteRecetaRepository.findAll();
    }
}
