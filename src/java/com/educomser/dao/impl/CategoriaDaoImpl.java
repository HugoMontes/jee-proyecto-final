package com.educomser.dao.impl;

import com.educomser.dao.CategoriaDao;
import com.educomser.model.Categoria;
import com.educomser.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CategoriaDaoImpl implements CategoriaDao{

    private Conexion conexion;
    private final static Logger LOGGER = Logger.getLogger(CategoriaDaoImpl.class);
    
    @Override
    public List<Categoria> findAll() {
        List<Categoria> list = new ArrayList<Categoria>();
        try {
            conexion = new Conexion();
            String sql = "SELECT id, categoria, descripcion FROM categoria";
            LOGGER.info(sql);
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setCategoria(rs.getString("categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
                list.add(cat);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            String msg = "Error al listar";
            LOGGER.error(msg, ex);
        } finally {
            conexion.close();
        }
        return list;
    }

    @Override
    public Categoria findById(int id) {
        Categoria cat = null;
        try {
            conexion = new Conexion();
            String sql = "SELECT id, categoria, descripcion FROM categoria WHERE id=?";
            PreparedStatement st = conexion.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            LOGGER.info(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setCategoria(rs.getString("categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            String msg = "Error al buscar";
            LOGGER.error(msg, ex);
        } finally {
            conexion.close();
        }
        return cat;
    }
    
}
