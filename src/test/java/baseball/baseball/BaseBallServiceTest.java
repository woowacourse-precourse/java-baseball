package baseball.baseball;

import baseball.dto.BaseBallGameInput;
import baseball.dto.BaseBallGameOutput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallServiceTest {

    BaseBallService baseBallService;

    @BeforeEach
    void beforeEach(){
        baseBallService = new BaseBallService();
    }

    @Test
    void ball3(){
        BaseBallGameInput in = new BaseBallGameInput("123", "231");
        BaseBallGameOutput out = baseBallService.playBall(in);
        assertThat(out.getBallCount()).isEqualTo(3);
        assertThat(out.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void ball1Strike1(){
        BaseBallGameInput in = new BaseBallGameInput("123", "413");
        BaseBallGameOutput out = baseBallService.playBall(in);
        assertThat(out.getBallCount()).isEqualTo(1);
        assertThat(out.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void strike2(){
        BaseBallGameInput in = new BaseBallGameInput("123", "125");
        BaseBallGameOutput out = baseBallService.playBall(in);
        assertThat(out.getBallCount()).isEqualTo(0);
        assertThat(out.getStrikeCount()).isEqualTo(2);
    }

    @Test
    void nothing(){
        BaseBallGameInput in = new BaseBallGameInput("123", "456");
        BaseBallGameOutput out = baseBallService.playBall(in);
        assertThat(out.getBallCount()).isEqualTo(0);
        assertThat(out.getStrikeCount()).isEqualTo(0);
    }
}