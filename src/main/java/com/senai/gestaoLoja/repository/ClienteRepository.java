package com.senai.gestaoLoja.repository;

import com.senai.gestaoLoja.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNome(String nome);
}
