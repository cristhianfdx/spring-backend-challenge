package com.backend.challenge.app.rest.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "debt")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DebtResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private BigDecimal totalAmount;

    @JsonProperty
    private Integer quoteNumber;

    @JsonProperty
    private BigDecimal balance;

    @JsonProperty
    private Integer term;

    @JsonProperty
    private String bankCode;

    @JsonProperty
    private String documentNumber;

    @JsonProperty
    private String status;

    public DebtResponse() {
        super();
    }

    private DebtResponse(Builder builder) {
        id = builder.id;
        totalAmount = builder.totalAmount;
        quoteNumber = builder.quoteNumber;
        balance = builder.balance;
        term = builder.term;
        bankCode = builder.bankCode;
        documentNumber = builder.documentNumber;
        status = builder.status;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Integer getQuoteNumber() {
        return quoteNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Integer getTerm() {
        return term;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getStatus() {
        return status;
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
        private String bankCode;
        private String documentNumber;
        private String status;

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

        public Builder bankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public DebtResponse build() {
            return new DebtResponse(this);
        }

    }

}
