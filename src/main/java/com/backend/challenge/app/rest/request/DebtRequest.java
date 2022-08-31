package com.backend.challenge.app.rest.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DebtRequest {

    @JsonProperty
    private String documentNumber;

    @JsonProperty
    private BigDecimal amount;

    @JsonProperty
    private Integer quoteNumber;

    @JsonProperty
    private Boolean totalPaid;

    public DebtRequest() {
        super();
    }

    private DebtRequest(Builder builder) {
        documentNumber = builder.documentNumber;
        amount = builder.amount;
        quoteNumber = builder.quoteNumber;
        totalPaid = builder.totalPaid;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getQuoteNumber() {
        return quoteNumber;
    }

    public Boolean getTotalPaid() {
        return totalPaid;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private String documentNumber;
        private BigDecimal amount;
        private Integer quoteNumber;
        private Boolean totalPaid;

        private Builder() {
            super();
        }

        public Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder quoteNumber(Integer quoteNumber) {
            this.quoteNumber = quoteNumber;
            return this;
        }

        public Builder totalPaid(Boolean totalPaid) {
            this.totalPaid = totalPaid;
            return this;
        }

        public DebtRequest build() {
            return new DebtRequest(this);
        }

    }

}
