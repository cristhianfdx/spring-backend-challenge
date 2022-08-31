package com.backend.challenge.app.api;

public class UserApi {

    private Long id;

    private String fullName;

    private String documentNumber;

    private String phoneNumber;

    public UserApi() {
        super();
    }

    private UserApi(Builder builder) {
        id = builder.id;
        fullName = builder.fullName;
        documentNumber = builder.documentNumber;
        phoneNumber = builder.phoneNumber;
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

    public static final class Builder {

        private Long id;
        private String fullName;
        private String documentNumber;
        private String phoneNumber;

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

        public UserApi build() {
            return new UserApi(this);
        }

    }

}
