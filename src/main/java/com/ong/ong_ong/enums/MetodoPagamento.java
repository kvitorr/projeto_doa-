package com.ong.ong_ong.enums;

public enum MetodoPagamento {
    CREDITO("Cartão de Crédito"),
    DEBITO("Cartão de Débito"),
    BOLETO("Boleto Bancário"),
    TRANSFERENCIA("Transferência Bancária"),
    PIX("PIX");

    private final String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

