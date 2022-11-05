package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void 게임_시작_안내문_출력(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Application.notifyGameStart();
        assertThat("숫자 야구 게임을 시작합니다.\n").isEqualTo(byteArrayOutputStream.toString());
    }

    @Test
    void 상대방의_수_범위(){
        List<Integer> computerNumbers = Application.createComputerNumbers();
        for (Integer computerNumber : computerNumbers) {
            assertThat(computerNumber)
                    .isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(9);
        }
    }

    @Test
    void 상대방의_서로_다른_임의의_수(){
        List<Integer> computerNumbers = Application.createComputerNumbers();
        Integer firstNum = computerNumbers.get(0);
        Integer secondNum = computerNumbers.get(1);
        Integer thirdNum = computerNumbers.get(2);
        assertThat(firstNum).isNotEqualTo(secondNum);
        assertThat(firstNum).isNotEqualTo(thirdNum);
        assertThat(secondNum).isNotEqualTo(thirdNum);
    }

    @Nested
    class 힌트_출력{
        @Test
        @DisplayName("1볼 1스트라이크")
        void case1(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(1, 2, 3);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("1볼 1스트라이크");
        }
        @Test
        @DisplayName("1볼")
        void case2(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(1, 4, 5);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("1볼");
        }
        @Test
        @DisplayName("2볼")
        void case3(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(6, 7, 1);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("2볼");
        }
        @Test
        @DisplayName("1스트라이크")
        void case4(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(2, 1, 6);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("1스트라이크");
        }
        @Test
        @DisplayName("3스트라이크")
        void case5(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(7, 1, 3);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("3스트라이크");
        }
        @Test
        @DisplayName("낫싱")
        void case6(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(2, 4, 5);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("낫싱");
        }
        @Test
        @DisplayName("2볼 1스트라이크")
        void case7(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(7, 3, 1);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("2볼 1스트라이크");
        }
        @Test
        @DisplayName("2스트라이크")
        void case8(){
            List<Integer> computerNumbers = List.of(7, 1, 3);
            List<Integer> userNumbers = List.of(7, 1, 5);
            String hint = Application.getHint(computerNumbers, userNumbers);
            assertThat(hint).isEqualTo("2스트라이크");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
