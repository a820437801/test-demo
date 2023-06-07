package com.wei.demo_feishurobot.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 82043
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FlyBookBootMessage {
    private String msgType;
}