package com.mycompany.Infrastructura.Db;

import com.mycompany.Infraestructura.Conexiones.Conexions;
import com.mycompany.Infrastructura.Modelos.ClienteModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
    private Conexions conexion;

    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexions(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModelo cliente){

        try {
            String sql = "INSERT INTO cliente (idpersona, fechaingreso, calificacion, estado)" +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, cliente.getIdPersona());
            preparedStatement.setDate(2, new java.sql.Date(cliente.getFechaIngreso().getTime()));
            preparedStatement.setString(3, cliente.getCalificacion());
            preparedStatement.setString(4, cliente.getEstado());

            int filasAfectadas = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                cliente.setIdCliente(idGenerado);
            }

            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "El cliente fue registrado correctamente!!!";
            } else {
                return "No se pudo registrar el cliente.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModelo cliente, int id){

        try {
            String sql = "UPDATE cliente SET " +
                    "idpersona = ?," +
                    "fechaingreso = ?," +
                    "calificacion = ?," +
                    "estado = ?" +
                    " WHERE idcliente = ?";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getIdPersona());
            preparedStatement.setDate(2, new java.sql.Date(cliente.getFechaIngreso().getTime()));
            preparedStatement.setString(3, cliente.getCalificacion());
            preparedStatement.setString(4, cliente.getEstado());
            preparedStatement.setInt(5, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "Los datos del cliente fueron modificados correctamente!!!";
            } else {
                return "No se pudo modificar el cliente.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModelo consultarCliente(int id){
        ClienteModelo cliente = new ClienteModelo();
        try {
            String sql = "SELECT * FROM cliente WHERE idcliente = ?";
            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getInt("idcliente"));
                cliente.setIdPersona(resultSet.getInt("idpersona"));
                cliente.setFechaIngreso(resultSet.getDate("fechaingreso"));
                cliente.setCalificacion(resultSet.getString("calificacion"));
                cliente.setEstado(resultSet.getString("estado"));

                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexion.conexionDB().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public String modificarCliente(ClienteModelo cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
