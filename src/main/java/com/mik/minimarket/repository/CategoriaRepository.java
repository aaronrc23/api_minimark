package com.mik.minimarket.repository;

import com.mik.minimarket.entity.Categoria;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Query(value="select count(*) from categorias where nombre = :nombre", nativeQuery=true)
    Long countByNombre(@Param("nombre") String nombre);



}
