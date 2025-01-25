/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nutriwise.nutriwise.repository;

import com.nutriwise.nutriwise.entity.Ingrediente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elsa
 */

@Repository
public class IngredienteJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplatenw;
    
    public static final String INSERT_QUERY=
            """
                INSERT INTO Ingrediente(NOMBRE)
                VALUES(?,?)
            """;
    
    public static final String UPDATE_QUERY=
            """
                UPDATE Ingrediente
                SET NOMBRE= ?
                WHERE ID= ?;
            
            """;
    
    public static final String DELETE_QUERY=
            """
                DELETE FROM Ingrediente
                WHERE ID= ?;
            """;
    
    public static final String SELECT_BY_ID_QUERY=
            """
                SELECT * FROM Ingrediente
                WHERE ID= ?;
            """;
    
    public static final String SELECT_ALL_QUERY=
            """
               SELECT * FROM Ingrediente; 
            """;
    
    public static final String SELECT_BY_NAME_QUERY=
            """
               SELECT * FROM Ingrediente 
               WHERE NOMBRE = ?; 
            """;
    
    public void insert(Ingrediente ingrediente){
        springJdbcTemplatenw.update(INSERT_QUERY, ingrediente.getNombre());
    }
    
    public void delete(Integer id){
        springJdbcTemplatenw.update(DELETE_QUERY, id);
    
    }
    
    public Ingrediente findById(Integer id){
        return springJdbcTemplatenw.queryForObject(SELECT_BY_ID_QUERY,
            new BeanPropertyRowMapper<>(Ingrediente.class), id);
    
    }
    
    public List<Ingrediente> findAll(){
        return springJdbcTemplatenw.query(SELECT_ALL_QUERY,
                new BeanPropertyRowMapper<>(Ingrediente.class), nombre);
    
    }
    
    public void update(Integer id, Ingrediente ingrediente){
        springJdbcTemplatenw.update(UPDATE_QUERY, ingrediente.getNombre(),id);
    
    }
    
}
