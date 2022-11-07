package baseball.dto;

public class GameScore {
    // 스트라이크와 볼 개수를 저장히기 위한 Integer형 변수
    Integer strike;
    Integer ball;

    // GameScore 클래스 생성자
    public GameScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    // 스트라이크 수를 얻기 위한 Getter
    public Integer getStrike() {
        return strike;
    }

    // 볼 수를 얻기 위한 Getter
    public Integer getBall() {
        return ball;
    }
}
