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
@Table(name="ingrediente")
public class Ingrediente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable= false)
    private String nombre;
    
    /*
     Habilitando constructores para ingrediente
    */
   
    public Ingrediente() {}

   
    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    /*
       Permitiendo acceso a atributos privados de la clase 
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
}
