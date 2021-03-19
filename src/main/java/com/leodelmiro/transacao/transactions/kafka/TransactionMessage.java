package com.leodelmiro.transacao.transactions.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.transacao.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {

    @JsonProperty("id")
    private String id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private EstablishmentMessage establishment;

    @JsonProperty("cartao")
    private CardMessage card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime createdAt;

    @Deprecated
    public TransactionMessage() {

    }


    public TransactionMessage(String id, BigDecimal value,
                              EstablishmentMessage establishment,
                              CardMessage card, LocalDateTime createdAt) {

        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentMessage getEstablishment() {
        return establishment;
    }

    public CardMessage getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Transaction toModel() {
        return new Transaction(id, value, establishment.toModel(), card.toModel(), createdAt);
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", establishment=" + establishment +
                ", card=" + card +
                ", createdAt=" + createdAt +
                '}';
    }
}
