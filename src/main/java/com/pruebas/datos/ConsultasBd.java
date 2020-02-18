/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrique
 */
public class ConsultasBd {
    
    private String consulta="";
    private  ResultSet rs=null;
    
    public ConsultasBd(){}
    
    
    public ResultSet obtenerUsuario(Connection conexion, String usuario, String password){
        
        consulta ="SELECT * FROM usuarios where Usuario=? AND Contrasena=?";
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            
            
            
            consultaPreparada.setString(1, usuario);
            consultaPreparada.setString(2, password);
            
            rs= consultaPreparada.executeQuery();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
}
