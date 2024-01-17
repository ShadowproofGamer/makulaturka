package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Account accountId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Address addressId;
    private Long points;

    public Client() {
    }

    public Client(Long id, Account accountId, Address addressId, Long points) {
        this.id = id;
        this.accountId = accountId;
        this.addressId = addressId;
        this.points = points;
    }

    public Client(Account accountId, Address addressId, Long points) {
        this.accountId = accountId;
        this.addressId = addressId;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", accountId=" + accountId.getId() +
                ", addressId=" + addressId.getId() +
                ", points=" + points +
                '}';
    }
}
