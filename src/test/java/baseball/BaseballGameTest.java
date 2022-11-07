package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



public class BaseballGameTest extends NsTest {

    @Test
    void 게임_시작_안내(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "589", "2");
                    assertThat(
                            stream(output().split("\n"))
                                    .filter(word -> word.equals("숫자 야구 게임을 시작합니다."))
                                    .count())
                            .isEqualTo(1);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Nested
    class 상대방의_수_생성{
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

        @Test
        void 게임_종료_안내(){
            assertRandomNumberInRangeTest(
                    () -> {
                        run("135", "1", "589", "1", "456", "2");
                        assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "3스트라이크",
                                "게임 종료", "애플리케이션을 종료합니다.");
                    },
                    1, 3, 5, 5, 8, 9, 4, 5, 6
            );
        }

    @Nested
    class 예외_처리{
        String inputUserValue;
        String inputGameOption;
        @Test
        void case1(){
            inputUserValue = "012";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case2(){
            inputUserValue = "1";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case3() {
            inputUserValue = "12";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case4(){
            inputUserValue = "1234";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case5(){
            inputUserValue = "000";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case6(){
            inputUserValue = "112";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case7(){
            inputUserValue = "121";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case8(){
            inputUserValue = "211";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case9(){
            inputUserValue = "111";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case10(){
            inputUserValue = "1.11";
            assertThatThrownBy(() -> Application.validUserNumbers(inputUserValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.", inputUserValue));
        }
        @Test
        void case11(){
            inputGameOption = "0";
            assertThatThrownBy(() -> Application.validGameOption(inputGameOption))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1 또는 2를 입력하세요", inputGameOption));
        }
        @Test
        void case12(){
            inputGameOption = "-1";
            assertThatThrownBy(() -> Application.validGameOption(inputGameOption))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1 또는 2를 입력하세요", inputGameOption));
        }
        @Test
        void case13(){
            inputGameOption = "ㅂ";
            assertThatThrownBy(() -> Application.validGameOption(inputGameOption))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1 또는 2를 입력하세요", inputGameOption));
        }
        @Test
        void case14(){
            inputGameOption = "@";
            assertThatThrownBy(() -> Application.validGameOption(inputGameOption))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1 또는 2를 입력하세요", inputGameOption));
        }
        @Test
        void case15(){
            inputGameOption = "02";
            assertThatThrownBy(() -> Application.validGameOption(inputGameOption))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.join("1 또는 2를 입력하세요", inputGameOption));
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
