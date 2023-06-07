/**
  * Copyright 2023 bejson.com 
  */
package com.wei.demo_feishurobot.domain.client.vo;

import lombok.Data;

/**
 * @author 82043
 */
@Data
public class Configuration {

    private String name;
    private String id;
    private String subdomain;
    private String hostname;
    private String proto;
    private String auth;
    private String addr;
    private String inspect;
    private String hostHeader;
    private String bindTls;
    private String crt;
    private String key;
    private String clientCas;
    private String remoteAddr;
    private String region;
    private String disableKeepAlives;
    private String redirectHttps;
    private String startType;
    private boolean permanent;

}