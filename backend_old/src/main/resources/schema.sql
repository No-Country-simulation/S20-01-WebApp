/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Elsa
 * Created: 18 ene 2025
 */
CREATE TABLE Ingrediente (
    id BIGINT NOT NULL PRIMARY KEY,         
    nombre VARCHAR(255) NOT NULL            
);


CREATE TABLE Ingrediente_Receta (
    id BIGINT NOT NULL PRIMARY KEY,         
    receta_id BIGINT NOT NULL,              
    ingrediente_id BIGINT NOT NULL,         
    cantidad INT NOT NULL,   
    unidad varchar(100) NOT NULL,                
    FOREIGN KEY (receta_id) REFERENCES receta(id) ON DELETE CASCADE,       
    FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id) ON DELETE CASCADE 
);


CREATE TABLE Receta(
    id BIGINT NOT NULL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL , 
    descripcion VARCHAR(255) NOT NULL ,
    instruccion VARCHAR(255) NOT NULL ,
);
