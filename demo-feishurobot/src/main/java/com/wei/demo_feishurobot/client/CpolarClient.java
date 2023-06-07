package com.wei.demo_feishurobot.client;

import com.wei.demo_feishurobot.domain.client.dto.LoginDto;
import com.wei.demo_feishurobot.domain.client.vo.CpolarResult;
import com.wei.demo_feishurobot.domain.client.vo.CpolarTunnel;
import com.wei.demo_feishurobot.domain.client.vo.LoginData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author 82043
 */
@FeignClient(url = "http://localhost:9200", name = "cpolarClient")
public interface CpolarClient {

    @GetMapping(value = "/api/v1/tunnels")
    CpolarResult<CpolarTunnel> getTunnels(@RequestHeader("Authorization") String auth);

    @PostMapping(value = "/api/v1/user/login")
    CpolarResult<LoginData> getLoginToken(@RequestBody LoginDto loginDto);

}
