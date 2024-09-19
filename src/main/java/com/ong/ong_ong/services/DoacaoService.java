package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Doacao;
import com.ong.ong_ong.database.repositories.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    public Optional<Doacao> findById(Long id) {
        return doacaoRepository.findById(id);
    }

    public Doacao save(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public void deleteById(Long id) {
        doacaoRepository.deleteById(id);
    }
}
