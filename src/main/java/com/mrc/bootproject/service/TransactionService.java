package com.mrc.bootproject.service;

public interface TransactionService {

    void aTranWithBNoTranWithoutTryCatch();

    void absameTranWithBThrowAndCatch();

    void aTranWithBRequiredNewTranBCatchException();
    
    void aTranWithBRequiredNewTranACatchException();

    void absameTranWithBThrowAndACatch();

}
