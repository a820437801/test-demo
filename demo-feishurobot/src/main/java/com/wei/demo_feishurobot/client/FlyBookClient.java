package com.wei.demo_feishurobot.client;

import com.wei.demo_feishurobot.domain.pojo.FlyBookCardMessage;
import com.wei.demo_feishurobot.domain.pojo.FlyBookRobotResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 82043
 */
@FeignClient(url = "${fly-book.robot.base-url}", name = "flyBookClient")
public interface FlyBookClient {

    /**
     * 发送卡片信息
     * @param flyBookCardMessage 参数
     * @return 结果
     */
    @PostMapping("${fly-book.robot.send-msg}")
    FlyBookRobotResult sendMsg(FlyBookCardMessage flyBookCardMessage);

}
