package baseball.view;

import baseball.Application;
import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends NsTest {

    @Test
    void 랜덤값_테스트() {
        Computer computer = new Computer();

        List<Integer> randomNumbers = computer.pickRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void 숫자0입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 영어입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}