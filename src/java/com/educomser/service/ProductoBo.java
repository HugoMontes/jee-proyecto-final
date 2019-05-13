package com.educomser.service;

import com.educomser.model.Producto;
import java.util.List;

public interface ProductoBo {
    public void save(Producto producto);
    public void update(Producto producto);
    public void delete(int id);
    public List<Producto> findAll();
    public Producto findById(int id);;
}
