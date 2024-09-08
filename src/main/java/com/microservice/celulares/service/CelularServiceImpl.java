package com.microservice.celulares.service;

import com.microservice.celulares.entity.Celular;
import com.microservice.celulares.repository.CelularDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularServiceImpl implements CelularService {

    @Autowired
    private CelularDao celularDao;

    @Override
    public List<Celular> findAll() {
        return (List<Celular>) celularDao.findAll();
    }

    @Override
    public Optional<Celular> findById(Long id) {
        return celularDao.findById(id);
    }

    @Override
    public Celular save(Celular celular) {
        return celularDao.save(celular);
    }

    @Override
    public boolean existsById(Long id) {
        return celularDao.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        celularDao.deleteById(id);
    }
}
