/**
  * Copyright 2023 bejson.com 
  */
package com.wei.demo_feishurobot.domain.client.vo;

import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2023-06-02 11:37:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
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