package com.ong.ong_ong.database.repositories;

import com.ong.ong_ong.database.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}
