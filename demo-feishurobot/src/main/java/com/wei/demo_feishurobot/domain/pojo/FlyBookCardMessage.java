package com.wei.demo_feishurobot.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 82043
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FlyBookCardMessage extends FlyBookBootMessage {
    private FlyBookCardMessageContent card;

    public FlyBookCardMessage(FlyBookCardMessageContent card) {
        super("interactive");
        this.card = card;
    }

    @Data
    public static class FlyBookCardMessageContent {
        private final FlyBookCardMessageConfig config;
        private final FlyBookCardMessageHeader header;
        private final List<FlyBookCardMessageElement> elements;
    }

    @Data
    @AllArgsConstructor
    public static class FlyBookCardMessageConfig {
        public static final FlyBookCardMessageConfig DEFAULT = new FlyBookCardMessageConfig(true, true, true);
        private boolean wideScreenMode;
        private boolean updateMulti;
        private boolean enableForward;
    }

    @Data
    public static class FlyBookCardMessageHeader {
        public static final String ERROR = "red";
        public static final String WARNING = "orange";
        public static final String SUCCESS = "green";
        public static final String PRIMARY = "blue";
        public static final String GREY = "grey";
        private final FlyBookCardMessageHeaderTitle title;
        private final String template;
    }

    @Data
    public static class FlyBookCardMessageHeaderTitle {
        private final String tag = "plain_text";
        private final String content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static abstract class FlyBookCardMessageElement {
        private String tag;
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class FlyBookCardMessageTextElement extends FlyBookCardMessageElement {

        private FlyBookCardMessageTextElementText text;

        public FlyBookCardMessageTextElement(FlyBookCardMessageTextElementText text) {
            super("div");
            this.text = text;
        }
    }

    @Data
    public static class FlyBookCardMessageTextElementText {
        private final String tag = "lark_md";
        private final String content;
    }
}