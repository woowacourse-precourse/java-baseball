package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultCheckerTest {
    ResultChecker resultChecker = new ResultChecker();

    @Test
    void checkRightAnswer_3스트라이크_입력_받으면_true_반환() {
        assertThat(resultChecker.checkRightAnswer("3스트라이크")).isTrue();
        assertThat(resultChecker.checkRightAnswer("1볼1스트라이크")).isFalse();
        assertThat(resultChecker.checkRightAnswer("2볼")).isFalse();
    }
}