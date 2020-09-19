package com.mrc.bootproject.service.impl;

import com.mrc.bootproject.domain.A;
import com.mrc.bootproject.mapper.AMapper;
import com.mrc.bootproject.mapper.BMapper;
import com.mrc.bootproject.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AServiceImpl implements AService {

    @Autowired
    private AMapper aMapper;

    @Autowired
    private BMapper bMapper;

    @Override
    @Transactional
    public void addA(String name) {
        A a = new A();
        a.setName(name);
        aMapper.insert(a);
    }
}
