package com.educomser.dao;

import com.educomser.model.Categoria;
import java.util.List;

public interface CategoriaDao {
    public List<Categoria> findAll();
    public Categoria findById(int id);
}
