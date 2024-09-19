package com.ong.ong_ong.database.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ong.ong_ong.enums.MetodoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "tb_doacao")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    @ManyToOne
    @JoinColumn(name = "doador_id", nullable = false)
    @JsonBackReference
    private Doador doador;
}
