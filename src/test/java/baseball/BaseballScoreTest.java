package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BaseballScoreTest {
    @Test
    void 스트라이크_수가_유효하지_않으면_예외_발생() {
        assertThatThrownBy(() -> new BaseballScore(-1, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_수가_유효하지_않으면_예외_발생() {
        assertThatThrownBy(() -> new BaseballScore(0, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크와_볼의_합이_전체_숫자의_수보다_크면_예외_발생() {
        assertThatThrownBy(() -> new BaseballScore(BaseballNumber.NUMBER_COUNT, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 야구_게임_점수를_출력한다_올_스트라이크() {
        BaseballScore score = new BaseballScore(BaseballNumber.NUMBER_COUNT, 0);
        String result = score.toString();
        String expected = Integer.toString(BaseballNumber.NUMBER_COUNT)
                + "스트라이크"
                + System.lineSeparator()
                + Integer.toString(BaseballNumber.NUMBER_COUNT)
                + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
//        String expected = "3스트라이크\n"
//                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertEquals(result, expected);
    }

    @Test
    void 야구_게임_점수를_출력한다_낫싱() {
        BaseballScore score = new BaseballScore(0, 0);
        String result = score.toString();
        String expected = "낫싱";
        assertEquals(result, expected);
    }

    @Test
    void 야구_게임_점수를_출력한다_1볼2스트라이크() {
        BaseballScore score = new BaseballScore(2, 1);
        String result = score.toString();
        String expected = "1볼 2스트라이크";
        assertEquals(result, expected);
    }

    @Test
    void 야구_게임_점수를_출력한다_2스트라이크() {
        BaseballScore score = new BaseballScore(2, 0);
        String result = score.toString();
        String expected = "2스트라이크";
        assertEquals(result, expected);
    }

    @Test
    void 야구_게임_점수를_출력한다_2볼() {
        BaseballScore score = new BaseballScore(0, 2);
        String result = score.toString();
        String expected = "2볼";
        assertEquals(result, expected);
    }
}
