package com.leodelmiro.transacao.transactions.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.transacao.transactions.Establishment;

public class EstablishmentMessage {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    @Deprecated
    public EstablishmentMessage(){

    }

    public EstablishmentMessage(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Establishment toModel(){
        return new Establishment(name, city, address);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EstablishmentResponse{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
