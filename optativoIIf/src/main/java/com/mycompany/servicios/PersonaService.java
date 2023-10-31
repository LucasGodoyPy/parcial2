/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicios;

import com.mycompany.infraestructura.Modelo.PersonaModelos;

/**
 *
 * @author hp
 */
public class PersonaService {
    PersonaService personaDB;
    public PersonaService (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personaDB = new PersonaService(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModelos persona){
        if(validarDatos(persona)){
           return personaDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(PersonaModelos persona){
        if(validarDatos(persona)){
            return personaDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public PersonaModelos consultarPersona(PersonaModelos persona){
        return  personaDB.consultarPersona(persona);
    }

    private boolean validarDatos(PersonaModelos persona) {
        try {
        if(persona.Nombre.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.Nombre.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    } 
}
