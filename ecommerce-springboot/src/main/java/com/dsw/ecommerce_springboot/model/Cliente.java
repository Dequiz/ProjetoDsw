package com.dsw.ecommerce_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "O nome é obrigatório")
    private String nome;
}
