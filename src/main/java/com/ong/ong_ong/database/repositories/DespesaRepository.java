package com.ong.ong_ong.database.repositories;

import com.ong.ong_ong.database.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
