/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.repository;

import com.nutriwise02.receta.spring.nutriwise02.receta.entity.Menu;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Elsa
 */
public interface MenuNutri02Repository extends JpaRepository<Menu, Integer> {

    List<Menu> findByTipodietaAndTipocomida(String tipodieta, String tipocomida);

    public Optional<Menu> findById(Integer id);

}
