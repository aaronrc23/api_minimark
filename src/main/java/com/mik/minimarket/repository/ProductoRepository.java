package com.mik.minimarket.repository;

import com.mik.minimarket.entity.Categoria;
import com.mik.minimarket.entity.Producto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query(value="select count(*) from productos where nombre=?",nativeQuery=true)
    public abstract int isExistName(String nombre);


    List<Producto> findByCategoria(Categoria categoria);



}
