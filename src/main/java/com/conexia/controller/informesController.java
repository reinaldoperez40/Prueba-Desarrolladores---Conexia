/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.model.MCliente;
import com.conexia.model.MFactura;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author repe
 */
@WebServlet(name = "informesController", urlPatterns = {"/informesController"})
public class informesController extends HttpServlet {

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
        String op = request.getParameter("op");
        try {
            switch (op) {
                case "list1":
                    list1(request, response);
                    break;
                case "list2":
                    list2(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void list1(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        MFactura factura = new MFactura();
        List listado = factura.getByTotalForCamarero();
        factura.close();
        
        MFactura factura2 = new MFactura();
        List listado2 = factura2.getByWithOutTotalForCamarero();
        factura2.close();

        request.setAttribute("inf1", listado);
        request.setAttribute("inf12", listado2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/informes/list1.jsp");
        dispatcher.forward(request, response);
    }
    
    public void list2(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        MFactura factura = new MFactura();
        List listado = factura.getByTopCliente();
        factura.close();

     
        request.setAttribute("inf2", listado);
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/informes/list2.jsp");
        dispatcher.forward(request, response);
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
