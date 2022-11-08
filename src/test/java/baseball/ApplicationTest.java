package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세자리의수생성기능_테스트(){
        assertSimpleTest(() -> {
            Computer computer = new Computer();
            computer.init();
            assertThat(computer.getResultNumberSize()).isEqualTo(3);
        });
    }

    @Nested
    class 게임진행기능_테스트 {
        @Test
        void 스트라이크_갯수_정상출력() {
            List<Integer> result = List.of(1, 2, 3);
            List<Integer> input = List.of(1, 2, 3);
            assertThat(Computer.countStrike(result, input)).isEqualTo(3);
        }

        @Test
        void 볼_갯수_정상출력() {
            List<Integer> result = List.of(1, 2, 3);
            List<Integer> input = List.of(1, 2, 3);
            assertThat(Computer.countBall(result, input)).isEqualTo(0);
        }

        @Test
        void 볼_갯수_정상출력_2() {
            List<Integer> result = List.of(1, 2, 3);
            List<Integer> input = List.of(1, 3, 2);
            assertThat(Computer.countBall(result, input)).isEqualTo(2);
        }

        @Test
        void 게임의_결과_출력(){
            int strike = 1;
            int ball = 2;
            Computer.printResult(strike, ball);
            assertThat(output()).contains("2볼 1스트라이크");

        }
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


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
