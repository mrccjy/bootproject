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
}
