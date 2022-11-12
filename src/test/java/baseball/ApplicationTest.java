package baseball;

import baseball.model.Computer;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static baseball.constValue.Constants.ExceptionMessage.*;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class ComputerFeatOrExceptionTest {
        @Test
        void 컴퓨터_숫자_생성기_크기_테스트() {
            Computer computer = new Computer();
            computer.generateComputerNumberThree();
            assertThat(computer.getComputerNumber().size()).isEqualTo(3);

        }

        @Test
        void 컴퓨터_숫자_생성기_범위_테스트() {
            Computer computer = new Computer();
            computer.generateComputerNumberThree();
            ArrayList<Integer> computerNumber = computer.getComputerNumber();
            assertThat(computerNumber).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);

            for (Integer num : computerNumber) {
                Assertions.assertTrue(num >= 1 && num <= 9);
            }
        }

        @Test
        void 컴퓨터_숫자_중복_숫자_테스트() {
            Computer computer = new Computer();
            computer.generateComputerNumberThree();
            ArrayList<Integer> computerNumber = computer.getComputerNumber();
            assertThat(computerNumber).doesNotHaveDuplicates();

        }

        @Test
        void 컴퓨터_숫자_플레이어_숫자_스트라이크_카운트_테스트() {
            Computer computer = new Computer();
            int strike = computer.countStrike(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<Integer>(List.of(1, 2, 3)));
            assertThat(3).isEqualTo(strike);
        }

        @Test
        void 컴퓨터_숫자_플레이어_숫자_볼_카운트_테스트() {
            Computer computer = new Computer();
            int ball = computer.countBall(new ArrayList<>(List.of(6, 7, 1)), new ArrayList<Integer>(List.of(7, 1, 3)));
            assertThat(2).isEqualTo(ball);
        }

        @Test
        void 힌트_출력_테스트() {
            Computer computer = new Computer();
            String hint = computer.getHint(new ArrayList<>(List.of(2, 1, 6)), new ArrayList<Integer>(List.of(7, 1, 3)));
            assertThat("1스트라이크").isEqualTo(hint);
        }

        @Test
        void 재시작_종료_입력_조건_에러_예외_테스트(){
            Computer computer = new Computer();
            assertThatThrownBy(() -> {
                computer.checkNotRestartInput("a");
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    @Nested
    class PlayerFeatOrExceptionTest{
        @Test
        void 입력값_숫자_에러_예외_테스트(){
            Player player = new Player("a");
            assertThatThrownBy(() -> {
                player.checkException();
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INPUT_NUM_OR_SIZE_ERROR_MESSAGE);
        }

        @Test
        void 입력값_사이즈_에러_예외_테스트(){
            Player player = new Player("1234");
            assertThatThrownBy(() -> {
                player.checkNotInputNumberOrOverSize();
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INPUT_NUM_OR_SIZE_ERROR_MESSAGE);
        }

        @Test
        void 입력값_중복_숫자_예외_테스트(){
            Player player = new Player("113");
            assertThatThrownBy(() -> {
                player.checkInputDuplicatedNumber();
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INPUT_DUPLICATE_ERROR_MESSAGE);
        }

        @Test
        void 입력값_문자열_리스트_변경_테스트(){
            Player player = new Player("123");
            List<Integer> list = List.of(1, 2, 3);
            ArrayList<Integer> real = new ArrayList<>(list);
            player.setInputNumber();
            assertThat(real).isEqualTo(player.getInputNumber());
        }


    }
}
