package com.ong.ong_ong.enums;

public enum TipoPessoa {
    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Jurídica"),
    VOLUNTARIO("Voluntário"),
    OUTRO("Outro");

    private final String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
