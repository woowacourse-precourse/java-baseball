package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    public void 스트라이크_볼_확인_1() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(1);
        assertThat(baseballGame.getBallCondition()).isEqualTo(1);
        assertThat(baseballGame.printCondition()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 스트라이크_볼_확인_2() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(1, 4, 5);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(0);
        assertThat(baseballGame.getBallCondition()).isEqualTo(1);
        assertThat(baseballGame.printCondition()).isEqualTo("1볼 ");
    }

    @Test
    public void 스트라이크_볼_확인_3() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(6, 7, 1);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(0);
        assertThat(baseballGame.getBallCondition()).isEqualTo(2);
        assertThat(baseballGame.printCondition()).isEqualTo("2볼 ");
    }

    @Test
    public void 스트라이크_볼_확인_4() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(2, 1, 6);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(1);
        assertThat(baseballGame.getBallCondition()).isEqualTo(0);
        assertThat(baseballGame.printCondition()).isEqualTo("1스트라이크");
    }

    @Test
    public void 스트라이크_볼_확인_5() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(2, 4, 5);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(0);
        assertThat(baseballGame.getBallCondition()).isEqualTo(0);
        assertThat(baseballGame.printCondition()).isEqualTo("낫싱");
    }

    @Test
    public void 스트라이크_볼_확인_6() {
        List<Integer> computer = Arrays.asList(7, 1, 3);
        List<Integer> player = Arrays.asList(7, 1, 3);

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.conditionCheck(computer, player);

        assertThat(baseballGame.getStrikeCondition()).isEqualTo(3);
        assertThat(baseballGame.getBallCondition()).isEqualTo(0);
        assertThat(baseballGame.isThreeStrike()).isTrue();
        assertThat(baseballGame.printCondition()).isEqualTo("3스트라이크");
    }
}