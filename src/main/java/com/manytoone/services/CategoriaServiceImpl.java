package com.manytoone.services;

import com.manytoone.dao.CategoriaDao;
import com.manytoone.models.Categoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class CategoriaServiceImpl implements  CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    public List<Categoria> findAll() {

        return categoriaDao.findAll();
    }
}
