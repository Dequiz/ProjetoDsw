package com.dsw.ecommerce_springboot.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dsw.ecommerce_springboot.model.Produto;  

import com.dsw.ecommerce_springboot.repository.ProdutoRepositorio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtor")
public class ProdutoController {

    @Autowired
    private ProdutoRepositorio repo;

    @GetMapping
    public List<Produto> listar(){
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto c){
        Produto salvo = repo.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        return repo.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(
        @PathVariable Long id,
        @Valid @RequestBody Produto c){
        return repo.findById(id)
        .map(existente -> {
            existente.setNome(c.getNome());
            existente.setPreco(c.getPreco());
            return ResponseEntity.ok(repo.save(existente));
        })
        .orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id){
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    
