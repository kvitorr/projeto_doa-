package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Objetivo;
import com.ong.ong_ong.database.repositories.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public List<Objetivo> findAll() {
        return objetivoRepository.findAll();
    }

    public Optional<Objetivo> findById(Long id) {
        return objetivoRepository.findById(id);
    }

    public Objetivo save(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public void deleteById(Long id) {
        objetivoRepository.deleteById(id);
    }
}
