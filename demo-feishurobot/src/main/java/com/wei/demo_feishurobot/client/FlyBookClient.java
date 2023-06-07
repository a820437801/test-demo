package com.wei.demo_feishurobot.client;

import com.wei.demo_feishurobot.domain.pojo.FlyBookCardMessage;
import com.wei.demo_feishurobot.domain.pojo.FlyBookRobotResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 82043
 */
@FeignClient(url = "https://open.feishu.cn/open-apis/bot", name = "flyBookClient")
public interface FlyBookClient {

    /**
     * 发送卡片信息
     * @param flyBookCardMessage 参数
     * @return 结果
     */
    @PostMapping("/v2/hook/de82cc47-a2cd-49f1-8a80-d0e68abc1280")
    FlyBookRobotResult sendMsg(FlyBookCardMessage flyBookCardMessage);

    /**
     * 发送卡片信息
     * @param flyBookCardMessage 参数
     * @return 结果
     */
    @PostMapping("/v2/hook/de82cc47-a2cd-49f1-8a80-d0e68abc1280")
    FlyBookRobotResult sendMsg(String flyBookCardMessage);

}
