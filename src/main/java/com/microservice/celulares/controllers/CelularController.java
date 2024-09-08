package com.microservice.celulares.controllers;

import com.microservice.celulares.entity.Celular;
import com.microservice.celulares.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/celulares")
public class CelularController {

    @Autowired
    private CelularService celularService;

    @GetMapping
    public List<Celular> getAllCelulares() {
        return celularService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Celular> getCelularById(@PathVariable Long id) {
        Optional<Celular> celular = celularService.findById(id);
        return celular.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Celular createCelular(@RequestBody Celular celular) {
        return celularService.save(celular);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Celular> updateCelular(@PathVariable Long id, @RequestBody Celular celular) {
        if (celularService.existsById(id)) {
            celular.setId(id);
            return ResponseEntity.ok(celularService.save(celular));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelular(@PathVariable Long id) {
        if (celularService.existsById(id)) {
            celularService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
