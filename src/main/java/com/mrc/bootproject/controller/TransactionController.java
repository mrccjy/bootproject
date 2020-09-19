package com.mrc.bootproject.controller;

import com.mrc.bootproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tran")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/aTranWithBNoTran")
    public void aTranWithBNoTran() {
        transactionService.aTranWithBNoTranWithoutTryCatch();
    }
    
    @RequestMapping("/aTranWithBRequiredNewTranBCatchException")
    public void aTranWithBRequiredNewTranBCatchException() {
        transactionService.aTranWithBRequiredNewTranBCatchException();
    }
    
    @RequestMapping("/aTranWithBRequiredNewTranCatchException")
    public void aTranWithBRequiredNewTranACatchException() {
        transactionService.aTranWithBRequiredNewTranACatchException();
    }
    
    @RequestMapping("/absameTranWithBThrowAndCatch")
    public void absameTranWithBThrowAndCatch() {
        transactionService.absameTranWithBThrowAndCatch();
    }

    @RequestMapping("/absameTranWithBThrowAndACatch")
    public void absameTranWithBThrowAndACatch() {
        transactionService.absameTranWithBThrowAndACatch();
    }


}
