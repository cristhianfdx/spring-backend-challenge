package com.backend.challenge.domain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Debt> debts;

    public Bank() {
        super();
    }

    private Bank(Builder builder) {
        code = builder.code;
        name = builder.name;
        user = builder.user;
        debts = builder.debts;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private String code;
        private String name;
        private User user;
        private List<Debt> debts;

        private Builder() {
            super();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder debts(List<Debt> debts) {
            this.debts = debts;
            return this;
        }

        public Bank build() {
            return new Bank(this);
        }

    }

}
