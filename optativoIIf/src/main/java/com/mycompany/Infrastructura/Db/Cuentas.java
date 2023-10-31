package com.mycompany.Infrastructura.Db;

import com.mycompany.Infraestructura.Conexiones.Conexions;
import com.mycompany.Infrastructura.Modelos.CuentasModelo;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Cuentas {
    private Conexions conexion;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexions(userBD, passDB, hostDB, portDB, dataBase);
    }

    public Cuentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String registrarCuenta(CuentasModelo cuentas){

        try {
            String sql = "INSERT INTO cuentas (idcliente, nrocuenta, fechaalta, tipocuenta, estado, saldoactual, nrocontrato, costomantenimiento, promedioacreditacion, tipomoneda)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, cuentas.getIdCliente());
            preparedStatement.setString(2, cuentas.getNumeroCuenta());
            preparedStatement.setDate(3, new java.sql.Date(cuentas.getFechaAlta().getTime()));
            preparedStatement.setString(4, cuentas.getTipoCuenta());
            preparedStatement.setString(5, cuentas.getEstado());
            preparedStatement.setFloat(6, cuentas.getSaldoActual());
            preparedStatement.setString(7, cuentas.getNumeroContrato());
            preparedStatement.setFloat(8, cuentas.getCostoMantenimiento());
            preparedStatement.setString(9, cuentas.getPromedioAcreditacion());
            preparedStatement.setString(10, cuentas.getTipoMoneda());

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "La cuenta Nro: " + cuentas.getNumeroCuenta() + " fue registrada correctamente!!!";
            } else {
                return "No se pudo registrar la cuenta.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuenta(CuentasModelo cuentas, int id){

        try {
            String sql = "UPDATE cuentas SET " +
                    "idcliente = ?," +
                    "nrocuenta = ?," +
                    "fechaalta = ?," +
                    "tipocuenta = ?," +
                    "estado = ?," +
                    "saldoactual = ?," +
                    "nrocontrato = ?," +
                    "costomantenimiento = ?," +
                    "promedioacreditacion = ?," +
                    "tipomoneda = ?" +
                    " WHERE id = ?";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, cuentas.getIdCliente());
            preparedStatement.setString(2, cuentas.getNumeroCuenta());
            preparedStatement.setDate(3, new java.sql.Date(cuentas.getFechaAlta().getTime()));
            preparedStatement.setString(4, cuentas.getTipoCuenta());
            preparedStatement.setString(5, cuentas.getEstado());
            preparedStatement.setFloat(6, cuentas.getSaldoActual());
            preparedStatement.setString(7, cuentas.getNumeroContrato());
            preparedStatement.setFloat(8, cuentas.getCostoMantenimiento());
            preparedStatement.setString(9, cuentas.getPromedioAcreditacion());
            preparedStatement.setString(10, cuentas.getTipoMoneda());
            preparedStatement.setInt(11, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "Los datos de la cuenta Nro.: " + cuentas.getNumeroCuenta() + " fueron modificados correctamente!!!";
            } else {
                return "No se pudo modificar la cuenta.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentasModelo consultarCuenta(int id){
        CuentasModelo cuentas = new CuentasModelo();
        try {
            String sql = "SELECT * FROM cuentas WHERE id = ?";
            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cuentas.setIdCliente(resultSet.getInt("idcliente"));
                cuentas.setNumeroCuenta(resultSet.getString("nrocuenta"));
                cuentas.setFechaAlta(resultSet.getDate("fechaalta"));
                cuentas.setTipoCuenta(resultSet.getString("tipocuenta"));
                cuentas.setEstado(resultSet.getString("estado"));
                cuentas.setSaldoActual(resultSet.getFloat("saldoactual"));
                cuentas.setNumeroContrato(resultSet.getString("nrocontrato"));
                cuentas.setCostoMantenimiento(resultSet.getFloat("costomantenimiento"));
                cuentas.setPromedioAcreditacion(resultSet.getString("promedioacreditacion"));
                cuentas.setTipoMoneda(resultSet.getString("tipomoneda"));

                return cuentas;
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

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
