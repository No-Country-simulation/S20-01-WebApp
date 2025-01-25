/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.entity;
import jakarta.persistence.*;

/**
 *
 * @author Elsa
 */

@Entity
@Table(name = "ingrediente_receta")
public class IngredienteReceta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingrediente_id", nullable = false)
    private Ingrediente ingrediente;

    @Column(nullable = false)
    private int cantidad; 
    
    @Column(nullable = false)
    private String unidad; 
    
    /*
        Creando constructor
    */
    
    public IngredienteReceta() {}

    public IngredienteReceta(Long id, Receta receta, Ingrediente ingrediente, int cantidad, String unidad) {
        this.id = id;
        this.receta = receta;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getUnidad() {
        return unidad;
    }

    public void setCantidad(String unidad) {
        this.unidad = unidad;
    }
   
}

