package com.backend.challenge.domain.services;

import java.util.List;

import com.backend.challenge.app.rest.request.DebtRequest;
import com.backend.challenge.app.rest.response.DebtResponse;

public interface DebtService {

    List<DebtResponse> getDebtsByUser(String documentNumber) throws Exception;

    DebtResponse getDebtById(Long debtId) throws Exception;

    DebtResponse paidDebt(Long debtId, DebtRequest request) throws Exception;

}
