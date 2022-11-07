package baseball;

import baseball.domain.Computer;
import baseball.utils.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private Computer computer;

    @BeforeEach
    void beforeEach() {
        computer = new Computer();
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class randomNumberTest {
        @Test
        void 컴퓨터_랜덤숫자_크기_테스트() throws Exception {
            computer.initiate();
            List<Integer> computerRandomNumbers = (List<Integer>) getPrivateField("baseballNumber", computer);

            int result = 3;

            assertThat(computerRandomNumbers.size()).isEqualTo(result);
        }

        @Test
        void 컴퓨터_랜덤값_숫자인지_확인() throws Exception {
            computer.initiate();
            List<Integer> computerRandomNumbers = (List<Integer>) getPrivateField("baseballNumber", computer);

            assertThat(computerRandomNumbers.stream().allMatch(number -> number >= 1 && number <= 9)).isTrue();
        }

    }

    @Nested
    class checkStrikeBallNothing {
        @Test
        void 스트라이크_테스트() throws Exception {
            List<Integer> computerRandomNumbers = List.of(1, 2, 3);

            int result = 2;
            List<Integer> question = List.of(1, 2, 4);
            Field privateFiled = computer.getClass().getDeclaredField("baseballNumber");
            privateFiled.setAccessible(true);
            privateFiled.set(computer, computerRandomNumbers);

            assertThat(computer.checkStrike(question)).isEqualTo(result);
        }

        @Test
        void 볼_테스트() throws Exception {
            List<Integer> computerRandomNumbers = List.of(1, 2, 3);

            int result = 2;
            List<Integer> question = List.of(2, 1, 4);
            Field privateFiled = computer.getClass().getDeclaredField("baseballNumber");
            privateFiled.setAccessible(true);
            privateFiled.set(computer, computerRandomNumbers);

            assertThat(computer.checkBall(question, computer.checkStrike(question))).isEqualTo(result);
        }

        @Test
        void 낫싱_테스트() throws Exception {
            List<Integer> computerRandomNumbers = List.of(1, 2, 3);

            boolean result = true;
            List<Integer> question = List.of(5, 6, 4);
            Field privateFiled = computer.getClass().getDeclaredField("baseballNumber");
            privateFiled.setAccessible(true);
            privateFiled.set(computer, computerRandomNumbers);

            assertThat(computer.checkNothing(question)).isEqualTo(result);
        }

        @Test
        void 게임이끝났는지_테스트() throws Exception {
            List<Integer> computerRandomNumbers = List.of(1, 2, 3);

            boolean result = true;
            List<Integer> question = List.of(1, 2, 3);
            Field privateFiled = computer.getClass().getDeclaredField("baseballNumber");
            privateFiled.setAccessible(true);
            privateFiled.set(computer, computerRandomNumbers);

            assertThat(computer.checkGameEnd(question)).isEqualTo(result);
        }
    }

    @Test
    void 숫자가아닌_문자를_입력했을때_테스트() {
        String input = "ab2";

        assertThatThrownBy(() -> Validation.isOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 외의 문자를 입력하셨습니다.");
    }

    @Test
    void 입력한_숫자가_3개인지_확인하는_테스트() {
        String input = "1234";

        assertThatThrownBy(() -> Validation.isNumberThree(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 3글자의 숫자입니다.");
    }

    @Test
    void 입력한_숫자가_1또는_2인지_테스트() {
        String input = "3";

        assertThatThrownBy(() -> Validation.isRestartOrEnd(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임이 끝난뒤에는 1 또는 2의 숫자를 입력해야만 합니다.");
    }

    @Test
    void 입력한_숫자가_중복인지_테스트() {
        String input = "313";

        assertThatThrownBy(() -> Validation.isDistinct(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }

    Object getPrivateField(String name, Object transferObject) throws Exception {
        Field privateFiled = transferObject.getClass().getDeclaredField(name);
        privateFiled.setAccessible(true);

        return privateFiled.get(transferObject);
    }
}
