package com.ong.ong_ong.database.repositories;

import com.ong.ong_ong.database.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
}
