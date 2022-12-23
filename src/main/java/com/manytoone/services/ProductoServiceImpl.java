package com.manytoone.services;



import com.manytoone.dao.ProductoDao;
import com.manytoone.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    private ProductoDao productoDao;

    @Override
    public Producto findById(Long Id) {
        return productoDao.findById(Id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);
    }
}

