package com.mycompany.Infrastructura.Modelos;

import java.util.Date;

public class CuentasModelo {
    private int identificador;
    private int idCliente;
    private String numeroCuenta;
    private Date fechaAlta;
    private String tipoCuenta;
    private String estado;
    private float saldoActual;
    private String numeroContrato;
    private float costoMantenimiento;
    private String promedioAcreditacion;
    private String tipoMoneda;
    public String Cliente;

    // Constructor (puedes agregar uno si es necesario)

    // Getters y setters

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public float getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(float costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public String getPromedioAcreditacion() {
        return promedioAcreditacion;
    }

    public void setPromedioAcreditacion(String promedioAcreditacion) {
        this.promedioAcreditacion = promedioAcreditacion;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public void setNroCuenta(String numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
