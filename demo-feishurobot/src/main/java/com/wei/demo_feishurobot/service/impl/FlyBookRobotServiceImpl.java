package com.wei.demo_feishurobot.service.impl;

import com.alibaba.fastjson.JSON;
import com.wei.demo_feishurobot.client.FlyBookClient;
import com.wei.demo_feishurobot.domain.pojo.FlyBookCardMessage;
import com.wei.demo_feishurobot.domain.pojo.FlyBookRobotResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 飞书Appender实现
 *
 * @author venus
 * @version 1
 */
@Service
public class FlyBookRobotServiceImpl {

    @Autowired
    private FlyBookClient flyBookClient;

    protected void append() {
        FlyBookCardMessage cardMessage = new FlyBookCardMessage(new FlyBookCardMessage.FlyBookCardMessageContent(
                FlyBookCardMessage.FlyBookCardMessageConfig.DEFAULT,
                new FlyBookCardMessage.FlyBookCardMessageHeader(
                        new FlyBookCardMessage.FlyBookCardMessageHeaderTitle("本地网站地址修改"),
                        FlyBookCardMessage.FlyBookCardMessageHeader.PRIMARY
                ),
                Collections.singletonList(
                        new FlyBookCardMessage.FlyBookCardMessageTextElement(
                                new FlyBookCardMessage.FlyBookCardMessageTextElementText("aaaaaa")
                        )
                )
        ));
        System.out.println(JSON.toJSONString(cardMessage));
        FlyBookRobotResult flyBookRobotResult = flyBookClient.sendMsg(cardMessage);
        System.out.println(flyBookRobotResult);
    }

}