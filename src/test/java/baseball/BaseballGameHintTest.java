package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameHintTest {

    BaseballGameHint baseballGameHint = new BaseballGameHint();

    @Test
    void generateHint() {
        String hint1 = baseballGameHint.generateHint(List.of(1, 2, 3), List.of(1, 2, 5));
        assertThat(hint1).isEqualTo("2스트라이크");

        String hint2 = baseballGameHint.generateHint(List.of(1, 2, 3), List.of(3, 5, 1));
        assertThat(hint2).isEqualTo("2볼");

        String hint3 = baseballGameHint.generateHint(List.of(1, 2, 3), List.of(4, 5, 6));
        assertThat(hint3).isEqualTo("낫싱");

        String hint4 = baseballGameHint.generateHint(List.of(1, 2, 3), List.of(1, 3, 6));
        assertThat(hint4).isEqualTo("1볼 1스트라이크");
    }
}