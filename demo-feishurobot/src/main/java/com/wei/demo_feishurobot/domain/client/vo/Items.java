/**
  * Copyright 2023 bejson.com 
  */
package com.wei.demo_feishurobot.domain.client.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 82043
 */
@Data
public class Items {

    private String id;
    private String name;
    private Configuration configuration;
    private String status;
    private String publicUrl;
    private List<publishTunnels> publishTunnels;

}