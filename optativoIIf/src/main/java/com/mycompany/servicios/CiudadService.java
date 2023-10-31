/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicios;


import com.mycompany.Infrastructura.Modelos.CiudadModelo;
import com.mycompany.presentacion.Ciudad;

/**
 *
 * @author hp
 */
public class CiudadService {
    Ciudad ciudadDB;
    public CiudadService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModelo ciudad){
        if(validarDatos(ciudad)){
           return ciudadDB.registrarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadModelo ciudad, int id){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarciudad(ciudad, id);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CiudadModelo consultarCiudad(int id){
        return  ciudadDB.consultarciudad(id);
    }

    private boolean validarDatos(CiudadModelo ciudad) {
        try {
        if(ciudad.Ciudad.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (ciudad.Ciudad.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
