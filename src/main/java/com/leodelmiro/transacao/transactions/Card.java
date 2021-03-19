package com.leodelmiro.transacao.transactions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cards")
public class Card {

    @Id
    private String id;

    @Column(nullable = false)
    private String email;

    @Deprecated
    public Card() {

    }

    public Card(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
