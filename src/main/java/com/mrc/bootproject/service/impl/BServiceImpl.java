package com.mrc.bootproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.mrc.bootproject.domain.A;
import com.mrc.bootproject.domain.AExample;
import com.mrc.bootproject.domain.B;
import com.mrc.bootproject.mapper.AMapper;
import com.mrc.bootproject.mapper.BMapper;
import com.mrc.bootproject.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class BServiceImpl implements BService {

    @Autowired
    private AMapper aMapper;

    @Autowired
    private BMapper bMapper;

    @Override
    public void addBWithoutTransaction(String name) {

        AExample ex = new AExample();
        ex.createCriteria().andNameEqualTo(name);

        List<A> list = aMapper.selectByExample(ex);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("empty");
        } else {
            System.out.println("not empty" + JSON.toJSON(list));
        }

        B b = new B();
        b.setName(name);
        bMapper.insert(b);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addBRequiredNewTransaction(String name) {
        try {
            B b = new B();
            b.setName(name);
            bMapper.insert(b);
            throw new Exception("主动抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addBTransactionThrowAndCatch(String name) {
        try {
            B b = new B();
            b.setName(name);
            bMapper.insert(b);
            throw new Exception("主动抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addBRequiredNewTransactionThrow(String name) throws Exception{
        B b = new B();
        b.setName(name);
        bMapper.insert(b);
        throw new Exception("主动抛出异常");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addBTransactionThrow(String name) throws Exception {
        B b = new B();
        b.setName(name);
        bMapper.insert(b);
        throw new Exception("主动抛出异常");
    }
}
