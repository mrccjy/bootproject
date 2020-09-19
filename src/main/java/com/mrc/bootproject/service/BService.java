package com.mrc.bootproject.service;

public interface BService {

    void addBWithoutTransaction(String name);

    void addBRequiredNewTransaction(String name);
    
    void addBTransactionThrowAndCatch(String name);

    void addBRequiredNewTransactionThrow(String name) throws Exception;

    void addBTransactionThrow(String name) throws Exception;
}
