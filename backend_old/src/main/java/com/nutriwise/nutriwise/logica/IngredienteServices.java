/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.logica;

package com.nutriwise.nutriwise.entity.Ingrediente;
package com.nutriwise.nutriwise.interfaz.postgres.IngredienteRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elsa
 */

@Service
public class IngredienteServices {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente crearIngrediente(Ingrediente ingrediente) {
        if (ingrediente.getNombre() == null || ingrediente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ingrediente es obligatorio.");
        }
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }
}