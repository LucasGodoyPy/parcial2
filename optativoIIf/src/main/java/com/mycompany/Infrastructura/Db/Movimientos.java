package com.mycompany.Infrastructura.Db;

import com.mycompany.Infraestructura.Conexiones.Conexions;
import com.mycompany.Infrastructura.Modelos.MovimientosModelo;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Movimientos {
    private Conexions conexion;

    public Movimientos(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexions(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientosModelo movimiento){

        try {
            String sql = "INSERT INTO movimientos (idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, movimiento.getIdCuenta());
            preparedStatement.setDate(2, new java.sql.Date(movimiento.getFechaMovimiento().getTime()));
            preparedStatement.setString(3, movimiento.getTipoMovimiento());
            preparedStatement.setFloat(4, movimiento.getSaldoAnterior());
            preparedStatement.setFloat(5, movimiento.getSaldoActual());
            preparedStatement.setFloat(6, movimiento.getMontoMovimiento());
            preparedStatement.setFloat(7, movimiento.getCuentaOrigen());
            preparedStatement.setFloat(8, movimiento.getCuentaDestino());
            preparedStatement.setFloat(9, movimiento.getCanal());

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "El registro de movimiento fue insertado correctamente!!!";
            } else {
                return "No se pudo registrar el movimiento.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(MovimientosModelo movimiento, int id){

        try {
            String sql = "UPDATE movimientos SET " +
                    "idcuenta = ?," +
                    "fechamovimiento = ?," +
                    "tipomovimiento = ?," +
                    "saldoanterior = ?," +
                    "saldoactual = ?," +
                    "montomovimiento = ?," +
                    "cuentaorigen = ?," +
                    "cuentadestino = ?," +
                    "canal = ?" +
                    " WHERE id = ?";

            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, movimiento.getIdCuenta());
            preparedStatement.setDate(2, new java.sql.Date(movimiento.getFechaMovimiento().getTime()));
            preparedStatement.setString(3, movimiento.getTipoMovimiento());
            preparedStatement.setFloat(4, movimiento.getSaldoAnterior());
            preparedStatement.setFloat(5, movimiento.getSaldoActual());
            preparedStatement.setFloat(6, movimiento.getMontoMovimiento());
            preparedStatement.setFloat(7, movimiento.getCuentaOrigen());
            preparedStatement.setFloat(8, movimiento.getCuentaDestino());
            preparedStatement.setFloat(9, movimiento.getCanal());
            preparedStatement.setInt(10, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            conexion.conexionDB().close();

            if (filasAfectadas > 0) {
                return "Los datos del movimiento fueron modificados correctamente!!!";
            } else {
                return "No se pudo modificar el movimiento.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientosModelo consultarMovimiento(int id){
        MovimientosModelo movimiento = new MovimientosModelo();
        try {
            String sql = "SELECT * FROM movimientos WHERE id = ?";
            PreparedStatement preparedStatement = conexion.conexionDB().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                movimiento.setIdCuenta(resultSet.getInt("idcuenta"));
                movimiento.setFechaMovimiento(resultSet.getDate("fechamovimiento"));
                movimiento.setTipoMovimiento(resultSet.getString("tipomovimiento"));
                movimiento.setSaldoAnterior(resultSet.getFloat("saldoanterior"));
                movimiento.setSaldoActual(resultSet.getFloat("saldoactual"));
                movimiento.setMontoMovimiento(resultSet.getFloat("montomovimiento"));
                movimiento.setCuentaOrigen(resultSet.getFloat("cuentaorigen"));
                movimiento.setCuentaDestino(resultSet.getFloat("cuentadestino"));
                movimiento.setCanal(resultSet.getFloat("canal"));

                return movimiento;
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
