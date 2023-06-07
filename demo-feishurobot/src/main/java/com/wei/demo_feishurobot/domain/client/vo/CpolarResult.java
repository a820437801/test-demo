/**
  * Copyright 2023 bejson.com 
  */
package com.wei.demo_feishurobot.domain.client.vo;

import lombok.Data;

/**
 * @author 82043
 */
@Data
public class CpolarResult <T> {

    private T data;
    private int code;
    private String message;

}