package com.leodelmiro.transacao.transactions;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_establishments")
public class Establishment {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Deprecated
    public Establishment() {

    }

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

}
