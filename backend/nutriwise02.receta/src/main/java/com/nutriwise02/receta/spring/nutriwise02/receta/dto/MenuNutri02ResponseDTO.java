/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.dto;

import java.util.List;

/**
 *
 * @author Elsa
 */
public class MenuNutri02ResponseDTO {

    private List<String> recetas;

    public MenuNutri02ResponseDTO(List<String> recetas) {
        this.recetas = recetas;
    }

    public List<String> getRecetas() {
        return recetas;
    }

    public void setRecetas(String body) {
        this.recetas = recetas;

    }

}
