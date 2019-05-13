package com.educomser.test;

import com.educomser.dao.ProductoDao;
import com.educomser.dao.impl.ProductoDaoImpl;
import com.educomser.model.Producto;

public class TestProductoListar {

    public static void main(String[] args) {
        ProductoDao pdao = new ProductoDaoImpl();
        System.out.println("-- LISTA DE PRODUCTOS --");
        for (Producto prod : pdao.findAll()) {
            System.out.println(prod.getId() + " \t "
                    + prod.getNombre()+ " \t "
                    + prod.getUnidadMedida()+ " \t "
                    + prod.getPrecio()+ " \t "
                    + prod.getStockActual()+ " \t "
                    + prod.getStockMinimo()+ " \t "
                    + prod.getFechaVencimiento());
        }
    }
}
