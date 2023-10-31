/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicios;

import com.mycompany.Infrastructura.Db.Cliente;
import com.mycompany.Infrastructura.Modelos.ClienteModelo;

/**
 *
 * @author hp
 */
public class ClienteService {
   Cliente clienteDB;
    public ClienteService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new Cliente(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModelo cliente){
        if(validarDatos(cliente)){
           return clienteDB.registrarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCliente(ClienteModelo cliente){
        if(validarDatos(cliente)){
            return clienteDB.modificarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public ClienteModelo consultarCliente(int id){
        return  clienteDB.consultarCliente(id);
    }

    private boolean validarDatos(ClienteModelo cliente) {
         
        try {
        if(cliente.Estado.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (cliente.Estado.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    } 
}
