package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void strike_ball_count로_힌트_메시지() {
        Map<String, Integer> result = new HashMap<>();

        result.put("strike", 3);
        result.put("ball", 0);
        Hint hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        result.put("strike", 2);
        result.put("ball", 0);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("2스트라이크");

        result.put("strike", 1);
        result.put("ball", 0);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("1스트라이크");

        result.put("strike", 1);
        result.put("ball", 2);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("2볼 1스트라이크");

        result.put("strike", 1);
        result.put("ball", 1);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("1볼 1스트라이크");

        result.put("strike", 0);
        result.put("ball", 3);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("3볼");

        result.put("strike", 0);
        result.put("ball", 2);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("2볼");

        result.put("strike", 0);
        result.put("ball", 1);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("1볼");

        result.put("strike", 0);
        result.put("ball", 0);
        hint = new Hint(result);
        assertThat(hint.makeHintMessage()).isEqualTo("낫싱");
    }

    @Test
    void player과_computer의_값으로_힌트_메시지() {
        Hint hint = new Hint();

        assertThat(hint.getBaseballResult(new Player(List.of(7, 2, 5)), new Computer(List.of(7, 2, 5)))).isEqualTo(
                "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        assertThat(hint.getBaseballResult(new Player(List.of(6, 3, 7)), new Computer(List.of(6, 3, 1)))).isEqualTo(
                "2스트라이크");

        assertThat(hint.getBaseballResult(new Player(List.of(6, 9, 1)), new Computer(List.of(6, 3, 4)))).isEqualTo(
                "1스트라이크");

        assertThat(hint.getBaseballResult(new Player(List.of(6, 2, 7)), new Computer(List.of(7, 2, 5)))).isEqualTo(
                "1볼 1스트라이크");

        assertThat(hint.getBaseballResult(new Player(List.of(1, 2, 3)), new Computer(List.of(3, 2, 1)))).isEqualTo(
                "2볼 1스트라이크");

        assertThat(hint.getBaseballResult(new Player(List.of(4, 9, 3)), new Computer(List.of(9, 3, 4)))).isEqualTo(
                "3볼");

        assertThat(hint.getBaseballResult(new Player(List.of(1, 8, 3)), new Computer(List.of(8, 7, 1)))).isEqualTo(
                "2볼");

        assertThat(hint.getBaseballResult(new Player(List.of(6, 9, 2)), new Computer(List.of(9, 3, 4)))).isEqualTo(
                "1볼");

        assertThat(hint.getBaseballResult(new Player(List.of(9, 3, 7)), new Computer(List.of(6, 2, 1)))).isEqualTo(
                "낫싱");
    }
}
