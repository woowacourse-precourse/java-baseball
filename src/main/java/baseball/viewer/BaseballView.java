package baseball.viewer;

public class BaseballView {
    private final BaseballTextType announcement;
    private final int ball;
    private final int strike;

    private BaseballView(BaseballTextType announcement, int ball, int strike) {
        this.announcement = announcement;
        this.ball = ball;
        this.strike = strike;
    }

    public BaseballTextType getAnnouncement() {
        return this.announcement;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public static MessageBuilder messagebuilder() {
        return new MessageBuilder();
    }

    public static class MessageBuilder {
        private BaseballTextType announcement;
        private int ball;
        private int strike;


        public MessageBuilder ball(int ball) {
            this.ball = ball;
            return this;
        }

        public MessageBuilder strike(int strike) {
            this.strike = strike;
            return this;
        }


        public MessageBuilder announcement(BaseballTextType announcement) {
            this.announcement = announcement;
            return this;
        }


        public BaseballView build() {
            return new BaseballView(announcement, ball, strike);
        }
    }
}
