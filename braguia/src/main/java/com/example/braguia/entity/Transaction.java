package com.example.braguia;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String type;

    @Column(nullable = false, unique = false, precision = 19, scale = 2)
    private BigDecimal value;

    @Column(nullable = false, unique = false, columnDefinition="TIMESTAMP")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="source_account_id", nullable = false, unique = false)
    private Account source_account;

    @ManyToOne
    @JoinColumn(name="destination_account_id", nullable = false, unique = false)
    private Account destination_account;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false, unique = false)
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Account getSourceAccount() {
        return source_account;
    }

    public void setSourceAccount(Account source_account) {
        this.source_account = source_account;
    }

    public Account getDestinationAccount() {
        return destination_account;
    }

    public void setDestinationAccount(Account destination_account) {
        this.destination_account = destination_account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}