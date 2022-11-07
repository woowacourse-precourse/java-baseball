package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseballServiceTest {
    private BaseballService baseballService;

    BaseballServiceTest() {
        this.baseballService = new BaseballService();
    }

    @Test
    void 스트라이크_체크() {
        int answer = 1;
        int strike = baseballService.isStrike(1, 1);
        Assertions.assertEquals(answer, strike);
    }

    @Test
    void 볼_체크() {
        int answer = 1;
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int index = 2;
        int strike = baseballService.isBall(numbers, answer, index);
        Assertions.assertEquals(answer, strike);
    }

    @Test
    void 재시작_상태_체크() {
        int restart = 1;
        baseballService.selectRestart(restart);
        Assertions.assertEquals(true,baseballService.getGameStatus());
    }

    @Test
    void 종료_상태_체크() {
        int restart = 2;
        baseballService.selectRestart(restart);
        Assertions.assertEquals(false,baseballService.getGameStatus());
    }
}
