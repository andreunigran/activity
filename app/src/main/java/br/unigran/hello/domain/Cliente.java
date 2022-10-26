package br.unigran.hello.domain;

import java.io.Serializable;

public class Cliente extends Pessoa {
    private Double credito;

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }
}
