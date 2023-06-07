package com.wei.demo_feishurobot.config;

import feign.Client;
import feign.Logger;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.SSLContext;

/**
 * Feign配置
 *
 * @author Charles7c
 * @date 2022/8/30 18:10
 */
//@Configuration
public class FeignConfig {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    /**
     * Feign 日志级别配置
     * @return /
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        if ("prod".equals(activeProfile)) {
            return Logger.Level.BASIC;
        }
        return Logger.Level.FULL;
    }
    
    /**
     * 解决 javax.net.ssl.SSLHandshakeException: java.security.cert.CertificateException: No subject alternative names present
     * @return /
     */
    @Bean
    public Client client() {
        try {
            SSLContext context = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            return new Client.Default(context.getSocketFactory(), new NoopHostnameVerifier());
        } catch (Exception e) {
            return new Client.Default(null, null);
        }
    }
}
