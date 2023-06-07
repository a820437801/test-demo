package com.wei.demo_feishurobot.domain.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 82043
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String password;

}
