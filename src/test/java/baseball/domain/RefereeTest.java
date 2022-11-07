package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setReferee() {
        AppConfig appConfig = new AppConfig();
        referee = appConfig.referee();
    }

    @Test
    void 스트라이크_볼_판정_테스트() {
        String userNumber = "132";
        Number judgeNumber = referee.judge(userNumber);

        int strike = judgeNumber.getStrike();
        int ball = judgeNumber.getBall();
        Number number = new Number(strike, ball);

        assertThat(number).isEqualTo(judgeNumber);
    }

    @Test
    void 리셋_테스트() {
        Computer computer = referee.getComputer();

        referee.reset();
        assertThat(computer).isNotEqualTo(referee.getComputer());
    }

    @Test
    void 재시작_검증_테스트() {
        String restartMessage = "1";
        assertThat(referee.judgeRestart(restartMessage)).isTrue();

        String quitMessage = "2";
        assertThat(referee.judgeRestart(quitMessage)).isFalse();
    }
}