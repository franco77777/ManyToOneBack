package com.manytoone.dao;

import com.manytoone.models.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
// se elige con que tabla trabajar y que tipo(id)
public interface ProductoDao extends JpaRepository<Producto, Long>  {

}
