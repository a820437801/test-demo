package com.wei.demo_feishurobot.service.impl;

import com.wei.demo_feishurobot.client.CpolarClient;
import com.wei.demo_feishurobot.domain.client.dto.LoginDto;
import com.wei.demo_feishurobot.domain.client.vo.CpolarResult;
import com.wei.demo_feishurobot.domain.client.vo.CpolarTunnel;
import com.wei.demo_feishurobot.domain.client.vo.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 82043
 */
@Service
public class CpolarServiceImpl {

    @Autowired
    private CpolarClient cpolarClient;

    @Value("${cpolar.email}")
    private String email;

    @Value("${cpolar.password}")
    private String password;

    public void getTunnels(String auth) {
        CpolarResult<CpolarTunnel> result = cpolarClient.getTunnels(auth);
        System.out.println(result);
    }

    public void getLoginToken() {

        LoginDto loginDto = new LoginDto(email, password);

        CpolarResult<LoginData> result = cpolarClient.getLoginToken(loginDto);
        System.out.println(result);
    }

}
