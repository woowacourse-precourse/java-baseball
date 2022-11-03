package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class MessageTest {
    Message message = new Message();

    @Test
    void result() {
        List<Integer> resultNothing = List.of(0, 0);
        List<Integer> resultBall = List.of(2, 0);
        List<Integer> resultStrike = List.of(0, 3);
        List<Integer> resultBoth = List.of(2, 1);

        assertThat(message.result(resultNothing)).isEqualTo("낫싱");
        assertThat(message.result(resultBall)).isEqualTo(resultBall.get(0) + "볼");
        assertThat(message.result(resultStrike)).isEqualTo(resultStrike.get(1) + "스트라이크");
        assertThat(message.result(resultBoth)).isEqualTo(resultBoth.get(0) + "볼 " + resultBoth.get(1) + "스트라이크");
    }
}