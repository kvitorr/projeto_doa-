package com.ong.ong_ong.services;

import com.ong.ong_ong.database.model.Meta;
import com.ong.ong_ong.database.repositories.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> findAll() {
        return metaRepository.findAll();
    }

    public Optional<Meta> findById(Long id) {
        return metaRepository.findById(id);
    }

    public Meta save(Meta meta) {
        return metaRepository.save(meta);
    }

    public void deleteById(Long id) {
        metaRepository.deleteById(id);
    }
}
