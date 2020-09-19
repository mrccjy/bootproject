package com.mrc.bootproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tran")
@RestController
public class TransactionController {

    @RequestMapping("/aTranWithBNoTran")
    public void aTranWithBNoTran() {

    }
}
