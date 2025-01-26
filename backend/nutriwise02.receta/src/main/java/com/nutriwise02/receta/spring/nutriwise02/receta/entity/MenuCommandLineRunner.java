/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.entity;

import com.nutriwise02.receta.spring.nutriwise02.receta.repository.MenuNutri02Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Elsa
 */
@Component
public class MenuCommandLineRunner implements CommandLineRunner {

    @Autowired
    private final MenuNutri02Repository menuRepository;

    public MenuCommandLineRunner(MenuNutri02Repository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      
        Menu menu1 = new Menu("paleo", "desayuno", "Receta01 para desayuno paleo");
        Menu menu2 = new Menu("vegana", "almuerzo", "Receta02 para almuerzo vegano");
        

        menuRepository.save(menu1);
        menuRepository.save(menu2);
     
    }
}
