/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicios;

import com.mycompany.Infraestructura.Modelos.CuentaModelo;

/**
 *
 * @author hp
 */
class CuentasService {
   CuentasService cuentaDB;
    public CuentasService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentaDB = new CuentasService(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(CuentaModelo cuenta){
        if(validarDatos(cuenta)){
           return cuentaDB.registrarCuenta(cuenta);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCuenta(CuentaModelo cuenta){
        if(validarDatos(cuenta)){
            return cuentaDB.modificarCuenta(cuenta);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CuentaModelo consultarCuenta(CuentaModelo cuenta){
        return  cuentaDB.consultarCuenta(cuenta);
    }

    private boolean validarDatos(CuentaModelo cuenta) {
        try {
        if(cuenta.NroCuenta.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (cuenta.NroCuenta.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }  
}
