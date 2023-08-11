package com.mik.minimarket.repository;

import com.mik.minimarket.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value="select count(*) from clientes where email=?",nativeQuery=true)
    public abstract int isExistName(String email);

}
