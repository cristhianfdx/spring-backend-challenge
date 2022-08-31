package com.backend.challenge.domain.services.impl;

import static java.lang.Boolean.TRUE;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.challenge.app.api.UserApi;
import com.backend.challenge.app.rest.request.DebtRequest;
import com.backend.challenge.app.rest.response.DebtResponse;
import com.backend.challenge.domain.models.Debt;
import com.backend.challenge.domain.repository.DebtRepository;
import com.backend.challenge.domain.services.DebtService;
import com.backend.challenge.domain.services.UserService;

@Service
public class DebtServiceImpl implements DebtService {

    private final UserService userService;

    private final DebtRepository debtRepository;

    @Autowired
    public DebtServiceImpl(UserService userService,
                           DebtRepository debtRepository) {
        this.userService = userService;
        this.debtRepository = debtRepository;
    }

    @Override
    public List<DebtResponse> getDebtsByUser(String documentNumber) throws Exception {
        UserApi user = userService.getByDocumentNumber(documentNumber);
        List<Debt> debts = debtRepository.findAllByDocumentNumber(user.getDocumentNumber());
        return debts.stream().map(this::buildDebtResponse).collect(Collectors.toList());
    }

    @Override
    public DebtResponse getDebtById(Long debtId) throws Exception {
        Optional<Debt> optionalDebt = debtRepository.findById(debtId);
        if (!optionalDebt.isPresent()) {
            throw new Exception("Debt not found.");
        }
        Debt debt = optionalDebt.get();
        UserApi user = userService.getByDocumentNumber(debt.getBank().getUser().getDocumentNumber());
        return buildCompleteDebtResponse(debt, user.getDocumentNumber());
    }

    @Override
    public DebtResponse paidDebt(Long debtId, DebtRequest request) throws Exception {
        Optional<Debt> optionalDebt = debtRepository.findById(debtId);

        if (!optionalDebt.isPresent()) {
            throw new Exception("Debt not found.");
        }

        Debt debt = optionalDebt.get();
        UserApi user = userService.getByDocumentNumber(debt.getBank().getUser().getDocumentNumber());
        BigDecimal balance = debt.getBalance();
        BigDecimal amount = request.getAmount();

        if (Debt.PAID.equals(debt.getStatus())) {
            throw new Exception("Debt has already been paid.");
        }

        if (TRUE.equals(request.getTotalPaid())) {
            if (!balance.equals(amount)) {
                throw new Exception("Amount to be paid must be equal to the balance of the debt.");
            }
            debt.setQuoteNumber(debt.getTerm());
            debt.setStatus(Debt.PAID);
        }

        debt.setQuoteNumber(request.getQuoteNumber());
        debt.setBalance(balance.subtract(amount));
        debtRepository.saveAndFlush(debt);
        return buildCompleteDebtResponse(debt, user.getDocumentNumber());
    }

    private DebtResponse buildCompleteDebtResponse(Debt debt, String documentNumber) {
        DebtResponse response = buildDebtResponse(debt);
        response.setDocumentNumber(documentNumber);
        return response;
    }

    private DebtResponse buildDebtResponse(Debt debt) {
        return DebtResponse.newBuilder()
                .totalAmount(debt.getTotalAmount())
                .quoteNumber(debt.getQuoteNumber())
                .bankCode(debt.getBank().getCode())
                .balance(debt.getBalance())
                .status(debt.getStatus())
                .term(debt.getTerm())
                .id(debt.getId())
                .build();
    }

}
