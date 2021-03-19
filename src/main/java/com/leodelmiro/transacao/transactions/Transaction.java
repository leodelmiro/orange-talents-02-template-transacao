package com.leodelmiro.transacao.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transactions")
public class Transaction {

    @Id
    private String id;

    @Positive
    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Establishment establishment;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Card card;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Deprecated
    public Transaction() {

    }

    public Transaction(String id, BigDecimal value,
                       Establishment establishment, Card card, LocalDateTime createdAt) {

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

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
