package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("Result 클래스 테스트")
    class ResultTest {

        @Test
        @DisplayName("0볼 0스트라이크 결과 테스트")
        void 결과테스트_낫싱() {
            Result result = new Result(0, 0);
            assertThat(result.toString()).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("1볼 0스트라이크 결과 테스트")
        void 결과테스트_1볼() {
            Result result = new Result(0, 1);
            assertThat(result.toString()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("0볼 1스트라이크 결과 테스트")
        void 결과테스트_1스트라이크() {
            Result result = new Result(1, 0);
            assertThat(result.toString()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("1볼 1스트라이크 결과 테스트")
        void 결과테스트_1볼_1스트라이크() {
            Result result = new Result(1, 1);
            assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
        }
    }

    @Nested
    @DisplayName("Computer 클래스 테스트")
    class ComputerTest {

        @Test
        @DisplayName("입력의 크기가 3보다 작다")
        void case1() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 2);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력의 크기가 3보다 크다")
        void case2() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 2, 3, 4);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력 값의 범위를 벗어난다")
        void case3() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 3, 10);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복 값이 입력된다")
        void case4() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(2, 2, 2);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("246", "135", "1", "597", "589", "2");
//                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
//            },
//            1, 3, 5, 5, 8, 9
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("1234"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
