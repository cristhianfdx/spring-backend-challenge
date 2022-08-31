package com.backend.challenge.domain.services;

import com.backend.challenge.app.api.UserApi;

public interface UserService {

    UserApi getByDocumentNumber(String documentNumber) throws Exception;

}
