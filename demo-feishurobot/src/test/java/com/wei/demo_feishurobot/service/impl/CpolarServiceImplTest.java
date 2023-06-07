package com.wei.demo_feishurobot.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CpolarServiceImplTest {

    @Autowired
    private CpolarServiceImpl cpolarService;

    @Test
    public void getTunnels() {
        cpolarService.getTunnels();
    }

    @Test
    public void getLoginToken() {
        cpolarService.getLoginToken();
    }

}