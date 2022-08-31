package com.backend.challenge.domain.services;

import java.util.List;

import com.backend.challenge.app.rest.response.BankResponse;

public interface BankService {

    List<BankResponse> getBanksByUser(String documentNumber) throws Exception;

}
