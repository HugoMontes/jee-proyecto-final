package com.educomser.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Conexion {

    /*
    private Connection connection;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DATABASE = "jseproyecto";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    public Conexion() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL+DATABASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            String msg="Error al cargar controlador de Base de Datos";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        } catch (SQLException ex) {
            String msg="Error en la cadena de conexion para la Base de Datos";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void close(){
        try {
            connection.close();
        } catch (SQLException ex) {
            String msg="Error al cerrar conexion";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }
    */
    
    private DataSource ds;
    private Connection connection;
    
    public Conexion() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/Educomser");
        } catch (NamingException ex) {
            String msg="Error en el pool de conexion";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }

    public Connection getConnection() {
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            String msg="Error en la conexion.";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException ex) {
            String msg="Error al cerrar conexion.";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }
}
