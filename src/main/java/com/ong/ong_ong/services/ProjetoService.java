package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Projeto;
import com.ong.ong_ong.database.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public void deleteById(Long id) {
        projetoRepository.deleteById(id);
    }
}

