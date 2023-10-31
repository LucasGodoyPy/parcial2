package com.mycompany.Infrastructura.Db;

import com.mycompany.Infraestructura.Conexiones.Conexions;
import com.mycompany.Infrastructura.Modelos.PersonaModelo;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Persona {
    private Conexions conexion;

    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexions(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModelo persona){

        try {
            String sql = "INSERT INTO persona (idciudad, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, persona.getIdCiudad());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellido());
            preparedStatement.setString(4, persona.getTipoDocumento());
            preparedStatement.setString(5, persona.getNroDocumento());
            preparedStatement.setString(6, persona.getDireccion());
            preparedStatement.setString(7, persona.getEmail());
            preparedStatement.setString(8, persona.getCelular());
            preparedStatement.setString(9, persona.getEstado());

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "La persona con nombre: " + persona.getNombre() + ", y apellido: " + persona.getApellido() + " fue registrada correctamente!!!";
            } else {
                return "No se pudo registrar la persona.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModelo persona, int id){

        try {
            String sql = "UPDATE persona SET " +
                    "nombre = ?," +
                    "apellido = ?," +
                    "tipodocumento = ?," +
                    "nrodocumento = ?," +
                    "direccion = ?," +
                    "email = ?," +
                    "celular = ?," +
                    "estado = ?" +
                    " WHERE id = ?";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setString(3, persona.getTipoDocumento());
            preparedStatement.setString(4, persona.getNroDocumento());
            preparedStatement.setString(5, persona.getDireccion());
            preparedStatement.setString(6, persona.getEmail());
            preparedStatement.setString(7, persona.getCelular());
            preparedStatement.setString(8, persona.getEstado());
            preparedStatement.setInt(9, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "Los datos de la persona " + persona.getNombre() + " " + persona.getApellido() + " fueron modificados correctamente!!!";
            } else {
                return "No se pudo modificar la persona.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModelo consultarPersona(int id){
        PersonaModelo persona = new PersonaModelo();
        try {
            String sql = "SELECT * FROM persona WHERE id = ?";
            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));

                return persona;
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
}
