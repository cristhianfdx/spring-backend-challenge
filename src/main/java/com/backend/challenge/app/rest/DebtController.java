package com.backend.challenge.app.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.challenge.app.rest.request.DebtRequest;
import com.backend.challenge.app.rest.response.DebtResponse;
import com.backend.challenge.domain.services.DebtService;

@RestController
@Validated
@RequestMapping("debts")
public class DebtController {

    private final DebtService debtService;

    @Autowired
    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping(path = "/user/{documentNumber}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<DebtResponse>> getDebtsByUser(@PathVariable("documentNumber") String documentNumber)
            throws Exception {
        return new ResponseEntity<>(debtService.getDebtsByUser(documentNumber), HttpStatus.OK);
    }

    @GetMapping(path = "/{debtId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DebtResponse> getDebtById(@PathVariable("debtId") Long debtId)
            throws Exception {
        return new ResponseEntity<>(debtService.getDebtById(debtId), HttpStatus.OK);
    }

    @PutMapping(path = "/{debtId}", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DebtResponse> paidDebt(@PathVariable("debtId") Long debtId,
                                                 @RequestBody @Valid DebtRequest request)
            throws Exception {
        return new ResponseEntity<>(debtService.paidDebt(debtId, request), HttpStatus.OK);
    }

}
