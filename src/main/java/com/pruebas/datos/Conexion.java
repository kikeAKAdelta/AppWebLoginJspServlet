/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrique
 */
public class Conexion {
    
    private String url="";
    private String servidor="";
    private Connection conexion=null;
    
    
    public Conexion(){}
    
    public Conexion(String database,String servidor,String usuarioMariaDb, String passMariaDb){
        
        this.servidor=servidor;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            url = "jdbc:mysql://"+servidor+"/"+database;
            
            conexion = DriverManager.getConnection(url,usuarioMariaDb,passMariaDb);
   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    
    public Connection cerrarConexion(){
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion = null;
        return conexion;
    }
            
    
  
    
    
}
