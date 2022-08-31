package com.backend.challenge.domain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bank> banks;

    public User() {
        super();
    }

    private User(Builder builder) {
        id = builder.id;
        fullName = builder.fullName;
        documentNumber = builder.documentNumber;
        phoneNumber = builder.phoneNumber;
        banks = builder.banks;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public static final class Builder {

        private Long id;
        private String fullName;
        private String documentNumber;
        private String phoneNumber;
        private List<Bank> banks;

        private Builder() {
            super();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder banks(List<Bank> banks) {
            this.banks = banks;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
