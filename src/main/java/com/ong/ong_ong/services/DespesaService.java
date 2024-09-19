package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Despesa;
import com.ong.ong_ong.database.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Optional<Despesa> findById(Long id) {
        return despesaRepository.findById(id);
    }

    public Despesa save(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public void deleteById(Long id) {
        despesaRepository.deleteById(id);
    }
}
