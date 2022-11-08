package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
    @Nested
    class 숫자_검사_메소드_테스트 {
        @Test
        void case1() {
            List<Integer> numberList = List.of(1, 2, 3);
            boolean result = true;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> numberList = List.of(1);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> numberList = List.of(1, 2, 2);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case4() {
            List<Integer> numberList = List.of(1, 2, 0);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }
    }

    @Test
    void 랜덤_숫자_생성() {
        Computer computer = new Computer();
        computer.setNumber();
        assertThat(Operator.isCorrectNumber(computer.getNumber())).isEqualTo(true);
    }

    @Test
    void 사용자에게_숫자_입력받기() {
        Player player = new Player();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        player.inputNumber();
        List<Integer> result = List.of(1, 2, 3);
        assertThat(player.getNumber()).isEqualTo(result);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}