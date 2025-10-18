package com.dsw.ecommerce_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsw.ecommerce_springboot.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{}
