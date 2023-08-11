package com.mik.minimarket.repository;

import com.mik.minimarket.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta,Integer> {


    @Query(value="select count(*) from venta where numdoc=?",nativeQuery=true)
    public abstract int isExistName(String numdoc);
}
