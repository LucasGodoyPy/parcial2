package com.mycompany.Infrastructura.Db;

import com.mycompany.Infraestructura.Conexiones.Conexions;
import com.mycompany.Infrastructura.Modelos.CiudadModelo;
import java.sql.SQLException;

public class Ciudad {
    private Conexions conexion;

    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase) {
        conexion = new Conexions(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModelo ciudad) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad (ciudad, departamento, postal) " +
                    "VALUES ('" +
                    ciudad.getNombreCiudad() + "', '" +
                    ciudad.getDepartamento() + "', '" +
                    ciudad.getCodigoPostal() + "')");
            conexion.conexionDB().close();
            return "La ciudad " + ciudad.getNombreCiudad() + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadModelo ciudad, int id) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudad.getNombreCiudad() + "'," +
                    "departamento = '" + ciudad.getDepartamento() + "'," +
                    "postal = '" + ciudad.getCodigoPostal() + "' " + " WHERE id = " + id);
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.getNombreCiudad() + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModelo consultarCiudad(int id) {
        CiudadModelo ciudad = new CiudadModelo();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad WHERE id = " + id));
            if (conexion.getResultadoQuery().next()) {
                ciudad.setNombreCiudad(conexion.getResultadoQuery().getString("ciudad"));
                ciudad.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
                ciudad.setCodigoPostal(conexion.getResultadoQuery().getInt("postal"));

                return ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
