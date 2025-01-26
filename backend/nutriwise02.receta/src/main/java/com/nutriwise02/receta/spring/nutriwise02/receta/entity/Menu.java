/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.entity;

import jakarta.persistence.*;

/**
 *
 * @author Elsa
 */
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tipodieta;

    @Column(nullable = false)
    private String tipocomida;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String receta;

    public Menu() {
    }

    public Menu(String tipodieta, String tipocomida, String receta) {
        this.tipodieta = tipodieta;
        this.tipocomida = tipocomida;
        this.receta = receta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipodieta() {
        return tipodieta;
    }

    public void setTipodieta(String tipodieta) {
        this.tipodieta = tipodieta;
    }

    public String getTipocomida() {
        return tipocomida;
    }

    public void setTipocomida(String tipocomida) {
        this.tipocomida = tipocomida;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

}
