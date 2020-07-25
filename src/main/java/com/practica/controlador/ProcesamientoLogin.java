/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.controlador;



import com.model.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pruebas.datos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author enrique
 */
@WebServlet(name = "ProcesamientoLogin", urlPatterns = {"/ProcesamientoLogin"})
public class ProcesamientoLogin extends HttpServlet {
    
    private String usuario;
    private String password;
    private Conexion cn = null;
    private ConsultasBd consultas=null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            usuario = request.getParameter("usuario");
            password = request.getParameter("pass");
            
            //El objeto RequestDispatcher me sirve para poder redirigir a una pagina
            
            RequestDispatcher rd;
            
            

            
            cn=new Conexion("proyecto_jsp", "localhost:3306", "root", "");
            //credenciales: erqa   contra: kike1234

            
            consultas = new ConsultasBd();
            ResultSet rs= consultas.obtenerUsuario(cn.getConexion(),usuario, password);
            
            try {
                
                
                //si el usuario existe
                if(rs.absolute(1)) {
                    UsuarioModel usuarioModel = new UsuarioModel();
                    
                    usuarioModel.setNombre(rs.getString("Nombre"));
                    usuarioModel.setApellido(rs.getString("Apellido"));
                    
                    request.setAttribute("usuarioModel",usuarioModel);  //enviamos el bean
                    rd = request.getRequestDispatcher("Home.jsp");  //establecemos ruta de envio
                    rd.forward(request, response);  //reenviamos a la ruta establecida
                    
                }else{  //si no existe el usuario
                    
                rd = request.getRequestDispatcher("Login.jsp");
                    
                request.setAttribute("usuarioNoAutorizado", "El usuario introducido no existe");
                
                out.println("Usuario no autorizado");
                rd.forward(request, response);
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(ProcesamientoLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
