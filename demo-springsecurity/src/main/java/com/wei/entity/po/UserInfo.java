package com.wei.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 82043
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class UserInfo {

    private Integer id;

    private String username;

    private String password;

    private String role;

}
