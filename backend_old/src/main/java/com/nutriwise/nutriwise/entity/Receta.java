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
@Table(name="receta")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private String instruccion;
    
    /*
        Habilitando constructor de la clase
    */
    public Receta(){}

    public Receta(Long id, String nombre, String descripcion, String instruccion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instruccion = instruccion;
    }

    /*
        Permitiendo acceso a los atributos privados de la clase
    
    */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }
        
}

