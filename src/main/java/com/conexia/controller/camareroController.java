/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entity.Camarero;
import com.conexia.model.MCamarero;
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
@WebServlet(name = "camareroController", urlPatterns = {"/camareroController"})
public class camareroController extends HttpServlet {
    public String msg;
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
                case "list":
                    list(request, response);
                    break;
                case "showedit":
                    showedit(request, response);
                    break;
                case "save":
                    save(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        MCamarero camarero = new MCamarero();
        List listado = camarero.getAll();
        camarero.close();

        request.setAttribute("l", listado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/camarero/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showedit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        
        msg = "";
        Camarero c = new Camarero(0, "", "", "");

        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;

        if (id != 0) {
            MCamarero camarero = new MCamarero();
            c = camarero.getById(id);
            camarero.close();
        }
        request.setAttribute("camarero", c);
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/camarero/form.jsp");
        dispatcher.forward(request, response);
        
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Camarero c = new Camarero();
        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");


        c.setId(id);
        c.setNombre(nombre);
        c.setApellido1(apellido1);
        c.setApellido2(apellido2);

        MCamarero camarero = new MCamarero();

        if (id == 0) {
            c = camarero.create(c);
        } else {
            c = camarero.update(c);
        }
        camarero.close();
        msg = "Acción Exitosa !!!";

        request.setAttribute("camarero", c);
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/camarero/form.jsp");
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
