package com.backend.challenge.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.challenge.app.rest.response.BankResponse;
import com.backend.challenge.domain.services.BankService;

@RestController
@Validated
@RequestMapping("banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping(path = "/user/{documentNumber}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<BankResponse>> getBanksByUser(@PathVariable("documentNumber") String documentNumber)
            throws Exception {
        return new ResponseEntity<>(bankService.getBanksByUser(documentNumber), HttpStatus.OK);
    }

}
