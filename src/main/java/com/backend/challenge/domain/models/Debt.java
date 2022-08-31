package com.backend.challenge.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "debts")
public class Debt {

    public static final String PAID = "PAID";
    public static final String OPEN = "OPEN";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "quote_number", nullable = false)
    private Integer quoteNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_code", updatable = false)
    private Bank bank;

    public Debt() {
        super();
    }

    private Debt(Builder builder) {
        id = builder.id;
        totalAmount = builder.totalAmount;
        quoteNumber = builder.quoteNumber;
        balance = builder.balance;
        term = builder.term;
        status = builder.status;
        bank = builder.bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(Integer quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private BigDecimal totalAmount;
        private Integer quoteNumber;
        private BigDecimal balance;
        private Integer term;
        private String status;
        private Bank bank;

        private Builder() {
            super();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder quoteNumber(Integer quoteNumber) {
            this.quoteNumber = quoteNumber;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder term(Integer term) {
            this.term = term;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder bank(Bank bank) {
            this.bank = bank;
            return this;
        }

        public Debt build() {
            return new Debt(this);
        }

    }

}
