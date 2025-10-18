package com.dsw.ecommerce_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsw.ecommerce_springboot.model.Cliente;

public interface ClienteRepostorio extends JpaRepository<Cliente,Long> {}
