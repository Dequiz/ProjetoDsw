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
import com.dsw.ecommerce_springboot.model.Cliente;  
import com.dsw.ecommerce_springboot.repository.ClienteRepostorio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepostorio repo;

    @GetMapping
    public List<Cliente> listar(){
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente c){
        Cliente salvo = repo.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<Cliente> buscar(@PathVariable Long id){
        return repo.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(
        @PathVariable Long id,
        @Valid @RequestBody Cliente c){
        return repo.findById(id)
        .map(existente -> {
            existente.setNome(c.getNome());
            existente.setEmail(c.getEmail());
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

    
