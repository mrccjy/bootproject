package com.mrc.bootproject.service.impl;

import com.mrc.bootproject.service.AService;
import com.mrc.bootproject.service.BService;
import com.mrc.bootproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AService aService;

    @Autowired
    private BService bService;

    /**
     * aservice有默认事务，bservice没有事务，b会加入前面的事务
     * aservice做的插入，bservice可以看到
     */
    @Transactional
    @Override
    public void aTranWithBNoTranWithoutTryCatch() {
        aService.addA("aTranWithBNoTranWithNoTryCatch");
        bService.addBWithoutTransaction("aTranWithBNoTranWithNoTryCatch");
    }
}
