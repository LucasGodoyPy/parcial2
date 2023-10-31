package com.mycompany.Infrastructura.Modelos;

public class CiudadModelo {
    private int id;
    private String nombreCiudad;
    private String departamento;
    private int codigoPostal;
    public String Ciudad;
    public String Departamento;
    public Object Postal;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    @Override
    public String toString() {
        return "CiudadModelo{" +
                "id=" + id +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                ", departamento='" + departamento + '\'' +
                ", codigoPostal=" + codigoPostal +
                '}';
    }

    public void setCiudad(String nombreCiudad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPostal(int codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
