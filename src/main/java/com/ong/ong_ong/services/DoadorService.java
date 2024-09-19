package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Doador;
import com.ong.ong_ong.database.repositories.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    public List<Doador> findAll() {
        return doadorRepository.findAll();
    }

    public Optional<Doador> findById(Long id) {
        return doadorRepository.findById(id);
    }

    public Doador save(Doador doador) {
        return doadorRepository.save(doador);
    }

    public void deleteById(Long id) {
        doadorRepository.deleteById(id);
    }
}
