package com.example.makulaturka.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Account {
    @Id
    /*@SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )*/
    @GeneratedValue(
            strategy = GenerationType.IDENTITY//, //SEQUENCE IDENTITY,
            //generator = "product_sequence"
    )
    //@Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String firstName;
    private Float lastName;
    private Float price;

    //TODO proper fields and constructors
    public Account(Long id) {
        this.id = id;
    }

    public Account() {

    }
}
