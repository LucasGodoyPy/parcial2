package com.mycompany.optativo.parcial;

import com.mycompany.Infrastructura.Db.Ciudad;
import com.mycompany.Infrastructura.Db.Cliente;
import com.mycompany.Infrastructura.Db.Cuentas;
import com.mycompany.Infrastructura.Db.Movimientos;
import com.mycompany.Infrastructura.Db.Persona;
import com.mycompany.Infrastructura.Modelos.CiudadModelo;
import com.mycompany.Infrastructura.Modelos.ClienteModelo;
import com.mycompany.Infrastructura.Modelos.CuentasModelo;
import com.mycompany.Infrastructura.Modelos.MovimientosModelo;
import com.mycompany.Infrastructura.Modelos.PersonaModelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Parcial1 {

    public static void main(String[] args) {

        // Conexiones a la base de datos (no cambiar)
        Ciudad ciudadConn = new Ciudad("postgres", "1234", "localhost", "5432", "lucian");
        Cliente clienteConn = new Cliente("postgres", "1234", "localhost", "5432", "lucian");
        Cuentas cuentaConn = new Cuentas("postgres", "1234", "localhost", "5432", "lucian");
        Movimientos movimientoConn = new Movimientos("postgres", "1234", "localhost", "5432", "lucian");
        Persona personaConn = new Persona("postgres", "1234", "localhost", "5432", "lucian");

        // Fecha actual
        LocalDate fechaActual = LocalDate.now();
        Date fecha = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Registro de nueva ciudad con valores modificados
        registrarNuevaCiudad(ciudadConn, "CiudadNueva", "NUEVODEPTO", 12345);

        // Registro de nuevo cliente con valores modificados
        registrarNuevoCliente(clienteConn, fecha, 42, "Inactivo");

        // Registro de nueva cuenta con valores modificados
        registrarNuevaCuenta(cuentaConn, fecha, 25, "9876543", "Ahorros", "Activo");
    }

    private static void registrarNuevaCiudad(Ciudad ciudadConn, String nombreCiudad, String departamento, int codigoPostal) {
        CiudadModelo nuevaCiudad = new CiudadModelo();
        nuevaCiudad.setCiudad(nombreCiudad);
        nuevaCiudad.setDepartamento(departamento);
        nuevaCiudad.setPostal(codigoPostal);

        ciudadConn.registrarCiudad(nuevaCiudad);
    }

    private static void registrarNuevoCliente(Cliente clienteConn, Date fecha, int calificacion, String estado) {
        ClienteModelo nuevoCliente = new ClienteModelo();
        nuevoCliente.setIdPersona(1);
        nuevoCliente.setFechaIngreso(fecha);
        nuevoCliente.setCalificacion(String.valueOf(calificacion));
        nuevoCliente.setEstado(estado);

        clienteConn.registrarCliente(nuevoCliente);
    }

    private static void registrarNuevaCuenta(Cuentas cuentaConn, Date fecha, int idCliente, String numeroCuenta, String tipoCuenta, String estado) {
        CuentasModelo nuevaCuenta = new CuentasModelo();
        nuevaCuenta.setIdCliente(idCliente);
        nuevaCuenta.setNroCuenta(numeroCuenta);
        nuevaCuenta.setFechaAlta(fecha);
        nuevaCuenta.setTipoCuenta(tipoCuenta);
        nuevaCuenta.setEstado(estado);

        cuentaConn.registrarCuenta(nuevaCuenta);
    }
}
