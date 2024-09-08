package com.microservice.celulares.service;

import com.microservice.celulares.entity.Celular;
import java.util.List;
import java.util.Optional;

public interface CelularService {
    List<Celular> findAll();
    Optional<Celular> findById(Long id);
    Celular save(Celular celular);
    boolean existsById(Long id);
    void deleteById(Long id);
}
