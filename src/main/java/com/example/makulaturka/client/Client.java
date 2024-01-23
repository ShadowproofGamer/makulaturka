package com.example.makulaturka.client;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.address.Address;
import jakarta.persistence.*;

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
    private Account account;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Address address;
    private Long points;

    public Client() {
    }

    public Client(Long id, Account account, Address address, Long points) {
        this.id = id;
        this.account = account;
        this.address = address;
        this.points = points;
    }

    public Client(Account account, Address address, Long points) {
        this.account = account;
        this.address = address;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountId) {
        this.account = accountId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressId) {
        this.address = addressId;
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
                ", accountId=" + account +
                ", addressId=" + address +
                ", points=" + points +
                '}';
    }
}
