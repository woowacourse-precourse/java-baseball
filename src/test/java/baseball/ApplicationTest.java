package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.util.List;

import static baseball.Constant.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 입력_길이_오류() {
        List<Integer> playerAnswer = List.of(1, 2, 3, 4);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Computer.validateNumber(playerAnswer));
        assertEquals(LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void 입력_중복_오류() {
        List<Integer> playerAnswer = List.of(1, 3, 3);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Computer.validateNumber(playerAnswer));
        assertEquals(DUPLICATE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void 입력_값_오류1() {
        List<Integer> playerAnswer = List.of(1, 2, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Computer.validateNumber(playerAnswer));
        assertEquals(INPUT_ERROR_MESSAGE, exception.getMessage());
    }


    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
