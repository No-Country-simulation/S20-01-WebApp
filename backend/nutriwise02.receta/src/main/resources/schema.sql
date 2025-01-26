/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  USUARIO
 * Created: 25 ene 2025
 */

CREATE TABLE IF NOT EXISTS menu (
    id SERIAL PRIMARY KEY,
    tipoDieta VARCHAR(255) NOT NULL,
    tipoComida VARCHAR(255) NOT NULL,
    receta TEXT NOT NULL
);


