package com.leodelmiro.transacao.transactions.kafka;

import com.leodelmiro.transacao.transactions.Card;

public class CardMessage {

    private String id;
    private String email;

    @Deprecated
    public CardMessage() {
    }

    public CardMessage(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Card toModel() {
        return new Card(id, email);
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
