/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.controlador;



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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesamientoLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesamientoLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            usuario = request.getParameter("usuario");
            password = request.getParameter("pass");
            
            //El objeto RequestDispatcher me sirve para poder redirigir a una pagina
            
            RequestDispatcher rd;
            
            rd = request.getRequestDispatcher("/Login.jsp");

            
            cn=new Conexion("proyecto_jsp", "localhost:3306", "root", "");
            
            consultas = new ConsultasBd();
            ResultSet rs= consultas.obtenerUsuario(cn.getConexion(),usuario, password);
            
            try {
                if(rs.absolute(1)) {
                    out.println("Usuario autorizado");
                }else{
                    
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
