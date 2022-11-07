package baseball.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class BaseBallTest {

    @Test
    void match() {
        BaseBall baseBall = new BaseBall();

        List<Integer> answer = baseBall.getAnswer();
        String strikeNumber = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String ballNumber = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining())
                .replace(String.valueOf(answer.get(2)), String.valueOf((answer.get(2) % 9) + 1));

        baseBall.match(ballNumber);
        Assertions.assertThat(baseBall.isMatch()).isEqualTo(false);
        Assertions.assertThat(baseBall.getStrike()).isEqualTo(2);

        baseBall.match(strikeNumber);
        Assertions.assertThat(baseBall.isMatch()).isEqualTo(true);
        Assertions.assertThat(baseBall.getStrike()).isEqualTo(3);
        Assertions.assertThat(baseBall.getBall()).isEqualTo(0);
    }
}