package com.ong.ong_ong.database.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ong.ong_ong.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "tb_doador")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Doacao> doacoes;

}
