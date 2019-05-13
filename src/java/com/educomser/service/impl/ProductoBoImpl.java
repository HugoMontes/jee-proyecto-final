package com.educomser.service.impl;

import com.educomser.dao.ProductoDao;
import com.educomser.dao.impl.ProductoDaoImpl;
import com.educomser.model.Producto;
import com.educomser.service.ProductoBo;
import java.util.List;

public class ProductoBoImpl implements ProductoBo{
    
    private final ProductoDao productoDao = new ProductoDaoImpl();
    
    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void update(Producto producto) {
        productoDao.update(producto);
    }

    @Override
    public void delete(int id) {
        productoDao.delete(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto findById(int id) {
       return productoDao.findById(id);
    }
    
}
