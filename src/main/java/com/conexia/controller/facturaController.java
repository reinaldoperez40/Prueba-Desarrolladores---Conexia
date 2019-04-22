/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.controller;

import com.conexia.entity.Camarero;
import com.conexia.entity.Cliente;
import com.conexia.entity.Cocinero;
import com.conexia.entity.Detallefactura;
import com.conexia.entity.Factura;
import com.conexia.entity.Mesa;
import com.conexia.model.MCamarero;
import com.conexia.model.MCliente;
import com.conexia.model.MCocinero;
import com.conexia.model.MDetallefactura;
import com.conexia.model.MFactura;
import com.conexia.model.MMesa;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "facturaController", urlPatterns = {"/facturaController"})
public class facturaController extends HttpServlet {

    public String msg;

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
                case "detalle_showedit":
                    detalle_showedit(request, response);
                    break;
                case "detalle_save":
                    detalle_save(request, response);
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
        msg = "";
        MFactura factura = new MFactura();
        List listado = factura.getAll();
        factura.close();

        request.setAttribute("l", listado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/factura/list.jsp");
        dispatcher.forward(request, response);

    }

    public void showedit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        
        msg = "";
        Date d = new Date();
        Factura c = new Factura(0,d,new Cliente(),new Camarero(),new Mesa(),0);

        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;

        if (id != 0) {
            MFactura factura = new MFactura();
            c = factura.getById(id);
            factura.close();
        }

        MCliente cliente = new MCliente();
        List c1 = cliente.getAll();
        cliente.close();

        MCamarero camarero = new MCamarero();
        List c2 = camarero.getAll();
        camarero.close();

        MMesa mesa = new MMesa();
        List c3 = mesa.getAll();
        mesa.close();

        MDetallefactura detallefactura = new MDetallefactura();
        List c4 = detallefactura.getAllBy(c);
        detallefactura.close();

        request.setAttribute("factura", c);
        request.setAttribute("cliente", c1);
        request.setAttribute("camarero", c2);
        request.setAttribute("mesa", c3);
        request.setAttribute("detallefactura", c4);

        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/factura/form.jsp");
        dispatcher.forward(request, response);
        
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        
        msg = "";
        
        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechafactura = null;
        try {
            fechafactura = dateFormatter.parse(request.getParameter("fechafactura"));
        } catch (ParseException ex) {
            Logger.getLogger(facturaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int total = Integer.parseInt(request.getParameter("total"));
        
        Factura c = new Factura();
        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("idcliente")));
        Camarero camarero = new Camarero(Integer.parseInt(request.getParameter("idcamarero")));
        Mesa mesa = new Mesa(Integer.parseInt(request.getParameter("idmesa")));
        
        c.setId(id);
        c.setFechafactura(fechafactura);
        c.setCliente(cliente);
        c.setCamarero(camarero);
        c.setMesa(mesa);     
        c.setTotal(total);
           
        MFactura facturaDao = new MFactura();

        if (id == 0) {
            c = facturaDao.create(c);
        } else {
            c = facturaDao.update(c);
        }
        facturaDao.close();
        
        MCliente clienteM = new MCliente();
        List c1 = clienteM.getAll();
        clienteM.close();

        MCamarero camareroM = new MCamarero();
        List c2 = camareroM.getAll();
        camareroM.close();

        MMesa mesaM = new MMesa();
        List c3 = mesaM.getAll();
        mesaM.close();

        MDetallefactura detallefacturaM = new MDetallefactura();
        List c4 = detallefacturaM.getAllBy(c);
        detallefacturaM.close();
        
        msg = "Acción Exitosa !!!";

        request.setAttribute("factura", c);
        request.setAttribute("cliente", c1);
        request.setAttribute("camarero", c2);
        request.setAttribute("mesa", c3);
        request.setAttribute("detallefactura", c4);
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/factura/form.jsp");
        dispatcher.forward(request, response);
        
    }

    public void detalle_showedit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        msg = "";
        int idfactura = (request.getParameter("factura") != null) ? Integer.parseInt(request.getParameter("factura")) : 0;

        if (idfactura != 0) {
            Factura factura = new Factura(idfactura);
            
            Detallefactura detalleFactura = new Detallefactura(0, factura, new Cocinero(), "", 0);

            int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;

            if (id != 0) {
                MDetallefactura detalleFacturaM = new MDetallefactura();
                detalleFactura = detalleFacturaM.getById(id);
                detalleFacturaM.close();
            }

            MCocinero cocineroM = new MCocinero();
            List cocinero = cocineroM.getAll();
            cocineroM.close();

            request.setAttribute("factura", factura);
            request.setAttribute("dfactura", detalleFactura);
            request.setAttribute("cocinero", cocinero);

            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/factura/detalle.jsp?factura=" + idfactura);
            dispatcher.forward(request, response);
        } else {
            msg = "Error: Factura no Seleccionada !!!";
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/factura/list.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void detalle_save(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        msg = "";
        
        int idfactura = (request.getParameter("idfactura") != null) ? Integer.parseInt(request.getParameter("idfactura")) : 0;
        int idcocinero = (request.getParameter("idcocinero") != null) ? Integer.parseInt(request.getParameter("idcocinero")) : 0;
        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
        int importe = Integer.parseInt(request.getParameter("importe"));
        String plato = request.getParameter("plato");
                 
        Factura factura = new Factura(idfactura);
        Cocinero cocinero = new Cocinero(idcocinero);
        Detallefactura detalleFactura = new Detallefactura();
        detalleFactura.setId(id);
        detalleFactura.setFactura(factura);
        detalleFactura.setCocinero(cocinero);
        detalleFactura.setPlato(plato);
        detalleFactura.setImporte(importe);

        MDetallefactura detallefacturaM = new MDetallefactura();
        
        if (id == 0) {
            detallefacturaM.create(detalleFactura);
        } else {
            detallefacturaM.update(detalleFactura);
        }
        detallefacturaM.close();
        
        MDetallefactura consultardetallefactura = new MDetallefactura();
        List<Detallefactura> r = consultardetallefactura.getAllBy(factura);
        consultardetallefactura.close();
        
        int total = 0;
        for (Detallefactura subtotal : r) {
            total = total + subtotal.getImporte();
        }
        
        MFactura facturaM = new MFactura();
        Factura facturaUpdateImporte = facturaM.getById(idfactura);
        facturaUpdateImporte.setTotal(total);
        facturaM.update(facturaUpdateImporte);
        facturaM.close();
        
        msg = "Acción Exitosa !!!";

        request.setAttribute("msg", msg);
        response.sendRedirect("app?page=factura&op=showedit&id=" + idfactura);

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
