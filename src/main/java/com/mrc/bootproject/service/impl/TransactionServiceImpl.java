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

    /**
     * ab同一个事务，b抛出异常并捕捉
     * ab都正常提交
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void absameTranWithBThrowAndCatch() {
        aService.addA("absameTranWithBThrowAndCatch");
        bService.addBTransactionThrowAndCatch("absameTranWithBThrowAndCatch");
    }

    /**
     * a默认事务，b新建事务，b抛出异常并捕捉
     * ab都正常提交
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void aTranWithBRequiredNewTranBCatchException() {
        aService.addA("aTranWithBRequiredNewTran");
        bService.addBRequiredNewTransaction("aTranWithBRequiredNewTran");
    }

    /**
     * a默认事务，b新建事务，b抛出异常不捕捉，a捕捉
     * a提交，b回滚
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void aTranWithBRequiredNewTranACatchException() {
        aService.addA("aTranWithBRequiredNewTranACatchException");
        try {
            bService.addBRequiredNewTransactionThrow("aTranWithBRequiredNewTranACatchException");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ab相同事务，b抛出异常a捕捉，ab回滚
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void absameTranWithBThrowAndACatch() {
        aService.addA("absameTranWithBThrowAndACatch");
        try {
            bService.addBTransactionThrow("absameTranWithBThrowAndACatch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
