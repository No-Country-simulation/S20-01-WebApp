/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.interfaz.postgres;
package com.nutriwise.nutriwise.entity.Receta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elsa
 */

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long>{
     List<Receta> findByNombre(String nombre);
    
}
