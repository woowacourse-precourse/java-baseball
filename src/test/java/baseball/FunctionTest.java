package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest extends NsTest {
    @Nested
    class ComputerTest {
        @Test
        @DisplayName("서로 다른 수로 이루어짐")
        void test1() {
            Computer computer = new Computer();
            List<Integer> number = computer.makeComputerNumber();

            assertThat(number.get(0)).isNotEqualTo(number.get(1));
            assertThat(number.get(1)).isNotEqualTo(number.get(2));
            assertThat(number.get(2)).isNotEqualTo(number.get(0));
        }

        @Test
        @DisplayName("각 자리의 수는 1~9로 이루어짐")
        void test2() {
            Computer computer = new Computer();
            List<Integer> number = computer.makeComputerNumber();

            assertThat(number.get(0)).isStrictlyBetween(0, 10);
            assertThat(number.get(1)).isStrictlyBetween(0, 10);
            assertThat(number.get(2)).isStrictlyBetween(0, 10);
        }
    }

    @Nested
    class UserTest {
        @Test
        @DisplayName("숫자가 아닌 경우")
        void test1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("asd"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(" "))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("!@#"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("서로 다른 수가 아닌 경우")
        void test2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("151"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("0이 포함된 수를 입력한 경우")
        void test3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("010"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("3자리의 수가 아닌 경우")
        void test4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class GameTest {
        @Test
        @DisplayName("게임종료 후 재시작")
        void test1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "1", "123", "248", "139", "2");
                        assertThat(output()).contains("3스트라이크", "1볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3, 1, 3, 9
            );
        }

        @Test
        @DisplayName("재시작 입력이 1,2가 아닌 경우")
        void test2() {
            Game game = new Game();

            System.setIn(new ByteArrayInputStream("3".getBytes()));
            assertThatThrownBy(() -> {
                game.isFinish();
            }).isInstanceOf(IllegalArgumentException.class);

            System.setIn(new ByteArrayInputStream(" ".getBytes()));
            assertThatThrownBy(() -> {
                game.isFinish();
            }).isInstanceOf(IllegalArgumentException.class);

            System.setIn(new ByteArrayInputStream("!@#".getBytes()));
            assertThatThrownBy(() -> {
                game.isFinish();
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}