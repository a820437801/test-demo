package com.wei.demo_springsecurity.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * 飞书Appender实现
 *
 * @author venus
 * @version 1
 */
@Setter
public class FlyBookAppender {

    @Autowired
    private RestTemplate restTemplate;

    private String alertUrl = "https://open.feishu.cn/open-apis/bot/v2/hook/de82cc47-a2cd-49f1-8a80-d0e68abc1280";

    protected void append() {
        FlyBookCardMessage cardMessage = new FlyBookCardMessage(new FlyBookCardMessageContent(
                FlyBookCardMessageConfig.DEFAULT,
                new FlyBookCardMessageHeader(
                        new FlyBookCardMessageHeaderTitle("错误日志告警"),
                        FlyBookCardMessageHeader.PRIMARY
                ),
                Arrays.asList(
                        new FlyBookCardMessageTextElement(
                                new FlyBookCardMessageTextElementText("**推送信息测试：**")
                        )
                )
        ));

        // 这个工具类源码未提供，也就是一个发送POST请求的工具方法
        // 各位根据喜好随便找个工具方法能发POST请求就行了🤣🤣
        //HttpRequestUtils.post(this.alertUrl, MediaType.APPLICATION_JSON_VALUE, JsonUtils.toUnderscoreJson(cardMessage));
    }

    @Data
    static abstract class FlyBookBootMessage {
        private final String msgType;
    }

    @EqualsAndHashCode(callSuper = true)
    static class FlyBookCardMessage extends FlyBookBootMessage {
        private final FlyBookCardMessageContent card;

        public FlyBookCardMessage(FlyBookCardMessageContent card) {
            super("interactive");
            this.card = card;
        }
    }

    @Data
    static class FlyBookCardMessageContent {
        private final FlyBookCardMessageConfig config;
        private final FlyBookCardMessageHeader header;
        private final List<FlyBookCardMessageElement> elements;
    }

    @Data
    @AllArgsConstructor
    static class FlyBookCardMessageConfig {
        public static final FlyBookCardMessageConfig DEFAULT = new FlyBookCardMessageConfig(true, true);
        private boolean wideScreenMode;
        private boolean enableForward;
    }

    @Data
    static class FlyBookCardMessageHeader {
        public static final String ERROR = "red";
        public static final String WARNING = "orange";
        public static final String SUCCESS = "green";
        public static final String PRIMARY = "blue";
        public static final String GREY = "grey";
        private final FlyBookCardMessageHeaderTitle title;
        private final String template;
    }

    @Data
    static class FlyBookCardMessageHeaderTitle {
        private final String tag = "plain_text";
        private final String content;
    }

    @Data
    static abstract class FlyBookCardMessageElement {
        private final String tag;
    }

    @EqualsAndHashCode(callSuper = true)
    static class FlyBookCardMessageTextElement extends FlyBookCardMessageElement {

        private final FlyBookCardMessageTextElementText text;

        public FlyBookCardMessageTextElement(FlyBookCardMessageTextElementText text) {
            super("div");
            this.text = text;
        }
    }

    @Data
    static class FlyBookCardMessageTextElementText {
        private final String tag = "lark_md";
        private final String content;
    }
}