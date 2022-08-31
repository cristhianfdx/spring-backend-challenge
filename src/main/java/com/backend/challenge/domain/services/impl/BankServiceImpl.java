package com.backend.challenge.domain.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.challenge.app.api.UserApi;
import com.backend.challenge.app.rest.response.BankResponse;
import com.backend.challenge.domain.models.Bank;
import com.backend.challenge.domain.repository.BankRepository;
import com.backend.challenge.domain.services.BankService;
import com.backend.challenge.domain.services.UserService;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    private final UserService userService;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository,
                           UserService userService) {
        this.bankRepository = bankRepository;
        this.userService = userService;
    }

    @Override
    public List<BankResponse> getBanksByUser(String documentNumber) throws Exception {
        UserApi user = userService.getByDocumentNumber(documentNumber);
        List<Bank> banks = bankRepository.findAllByUserId(user.getId());
        return banks.stream().map(this::buildBankResponse).collect(Collectors.toList());
    }

    private BankResponse buildBankResponse(Bank bank) {
        return new BankResponse(bank.getCode(), bank.getName());
    }

}
