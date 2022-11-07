package baseball.controller.dto;

import baseball.model.domain.BaseBall;

public class BaseBallDto {

    public static class Response {

        private Long id;
        private Integer ball;
        private Integer strike;
        private Boolean isMatch;

        private Response(Long id, Integer ball, Integer strike, Boolean isMatch) {
            this.id = id;
            this.ball = ball;
            this.strike = strike;
            this.isMatch = isMatch;
        }

        public static Response of(Long id, Integer ball, Integer strike, Boolean isMatch) {
            return new Response(id, ball, strike, isMatch);
        }

        public static Response from(BaseBall baseBall) {
            return new Response(baseBall.getId(), baseBall.getBall(), baseBall.getStrike(), baseBall.isMatch());
        }

        public Long getId() {
            return id;
        }

        public int getBall() {
            return ball;
        }

        public int getStrike() {
            return strike;
        }

        public boolean isMatch() {
            return isMatch;
        }
    }
}
