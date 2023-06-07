package com.wei.demo_feishurobot.client;

import com.wei.demo_feishurobot.domain.client.dto.LoginDto;
import com.wei.demo_feishurobot.domain.client.vo.CpolarResult;
import com.wei.demo_feishurobot.domain.client.vo.CpolarTunnel;
import com.wei.demo_feishurobot.domain.client.vo.LoginData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 82043
 */
@FeignClient(url = "http://localhost:9200", name = "cpolarClient")
public interface CpolarClient {

    @GetMapping(value = "/api/v1/tunnels",
            headers = {"Authorization=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODYyODA1MjIsImlhdCI6MTY4NjEwNzcyMiwiVXNlcklEIjowLCJVc2VybmFtZSI6IiIsIkVtYWlsIjoiODIwNDM3ODAxQHFxLmNvbSIsIkFwaVNlcnZpY2VUb2tlbiI6ImV5SmhiR2NpT2lKSVV6STFOaUlzSW5SNWNDSTZJa3BYVkNKOS5leUpsZUhBaU9qRTJPRFl5T0RBMU1qSXNJbWxoZENJNk1UWTROakV3TnpjeU1pd2lWWE5sY2tsRUlqb3hOVFF6TURZc0lsVnpaWEp1WVcxbElqb2k1cEtlNVoyUDZZS2o1WS1qNTZDMDZaS2ZJaXdpUlcxaGFXd2lPaUk0TWpBME16YzRNREZBY1hFdVkyOXRJbjAuQVROb01OeXUwRFRDNERGM2pZYjg1b3hOcXVDcG1jTFRzbFJaY29RTk5BZyJ9.zLSKKpByKwihWGcaj_nWV5l1gM6vA8xzcyyqRYccqqM"})
    CpolarResult<CpolarTunnel> getTunnels();

    @PostMapping(value = "/api/v1/user/login")
    CpolarResult<LoginData> getLoginToken(@RequestBody LoginDto loginDto);

}
