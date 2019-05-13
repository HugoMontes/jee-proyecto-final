package com.educomser.controller;

import com.educomser.model.Producto;
import com.educomser.service.ProductoBo;
import com.educomser.service.impl.ProductoBoImpl;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    private final ProductoBo productoBo = new ProductoBoImpl();

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

        if (request.getParameter("action") == null) {
            listarProductosAction(request, response);
        } else if (request.getParameter("action").equals("nuevo")) {
            nuevoProductoAction(request, response);
        } else if (request.getParameter("action").equals("guardar")) {
            guardarProductoAction(request, response);
        } else if (request.getParameter("action").equals("editar")) {
            editarProductoAction(request, response);
        }
    }

    private void listarProductosAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productos", productoBo.findAll());
        request.getRequestDispatcher("producto/listar.jsp").forward(request, response);
    }

    private void nuevoProductoAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("producto/nuevo.jsp").forward(request, response);
    }

    private void guardarProductoAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Producto prod = new Producto();
            prod.setId(Integer.parseInt(request.getParameter("id")));
            prod.setNombre(request.getParameter("nombre"));
            prod.setUnidadMedida(request.getParameter("unidadMedida"));
            prod.setPrecio(Double.parseDouble(request.getParameter("precio")));
            prod.setStockActual(Integer.parseInt(request.getParameter("stockActual")));
            prod.setStockMinimo(Integer.parseInt(request.getParameter("stockMinimo")));
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            prod.setFechaVencimiento(df.parse(request.getParameter("fechaVencimiento")));
            prod.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
            if (prod.getId() == 0) {
                productoBo.save(prod);
                request.setAttribute("message", "El producto fue guardado exitosamente");
            } else {
                productoBo.update(prod);
                request.setAttribute("message", "El producto fue editado exitosamente");
            }
            listarProductosAction(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarProductoAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("producto", productoBo.findById(id));
        request.getRequestDispatcher("producto/editar.jsp").forward(request, response);
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
