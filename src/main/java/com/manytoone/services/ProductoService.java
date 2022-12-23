package com.manytoone.services;



import com.manytoone.models.Producto;

import java.util.List;

public interface ProductoService {
    public Producto findById(Long Id);
    public Producto save (Producto producto);
    public List<Producto> findAll();
    public void delete (Long id);
}

