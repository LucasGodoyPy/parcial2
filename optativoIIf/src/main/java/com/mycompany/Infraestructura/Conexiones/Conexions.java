package com.mycompany.Infraestructura.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexions {
    private String userDB;
    private String passDB;
    private String portDB;
    private String hostDB;
    private String dataBase;
    private String url;
    private Connection connection;
    private Statement querySQL;
    private ResultSet resultQuery;
    
    public Conexions(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        this.userDB = userBD;
        this.passDB = passDB;
        this.portDB = portDB;
        this.dataBase = dataBase;
        this.hostDB = hostDB;
        this.url = "jdbc:postgresql://" + this.hostDB + ":" + this.portDB + "/" + dataBase;
    }

    public Connection conexionDB() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(this.url, this.userDB, this.passDB);
            }
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Statement getQuerySQL(){
        return this.querySQL;
    }

    public void setQuerySQL(Statement sentencia){
        this.querySQL = sentencia;
    }

    public ResultSet getResultadoQuery(){
        return this.resultQuery;
    }
    
    public void setResultadoQuery(ResultSet resultado){
        this.resultQuery = resultado;
    }
    
    public void close() {
        try {
            if (resultQuery != null) {
                resultQuery.close();
            }
            if (querySQL != null) {
                querySQL.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
