package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest {
    @Nested
    class GenerateRandomNumberStringTest {
        @RepeatedTest(100)
        @DisplayName("컴퓨터가 생성한 수 테스트")
        void generateRandomNumberString_Success() {
            String randomNumberString = Application.generateRandomNumberString();
            List<Character> usedNumber = new ArrayList<>();

            // 컴퓨터가 생성한 수는 3자리 수여야 한다
            assertThat(randomNumberString.length()).isEqualTo(3);

            for (int i = 0; i < randomNumberString.length(); i++) {
                char ch = randomNumberString.charAt(i);

                // 각 자리는 1~9까지의 수이고 중복되어서는 안된다.
                assertThat(ch).isGreaterThanOrEqualTo('1')
                        .isLessThanOrEqualTo('9');
                assertThat(usedNumber).doesNotContain(ch);

                usedNumber.add(ch);
            }
        }
    }

    @Nested
    class GetGuessNumberInputTest {
        @Test
        @DisplayName("기본흐름: 플레이어가 중복되지 않는 1~9 세자리 수 입력하는 경우 입력값 그대로 반환")
        void getGuessNumberInput_ValidInput_Success() {
            String guessNumberInput = "123";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThat(Application.getGuessNumberInput()).isEqualTo(guessNumberInput);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 2자리를 입력하는 경우")
        void getGuessNumberInput_InvalidLength2_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "12";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::getGuessNumberInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 4자리를 입력하는 경우")
        void getGuessNumberInput_InvalidLength4_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "1234";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::getGuessNumberInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 1~9 숫자가 아닌 값을 입력하는 경우")
        void getGuessNumberInput_InvalidCharacter_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "12a";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::getGuessNumberInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 0이 들어간 값 입력하는 경우")
        void getGuessNumberInput_InvalidNumber_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "104";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::getGuessNumberInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 중복된 값을 입력하는 경우")
        void getGuessNumberInput_DuplicatedNumber_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "141";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::getGuessNumberInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class CalcStrikeAndBallCountTest {
        @Test
        @DisplayName("스트라이크 1개인 경우 테스트(같은 수가 같은 자리에 있는 숫자의 개수 1개)")
        void calcStrikeCount_matchOne_Return1() {
            String answer = "123";
            assertThat(Application.calcStrikeCount(answer, "156")).isEqualTo(1);
            assertThat(Application.calcStrikeCount(answer, "926")).isEqualTo(1);
            assertThat(Application.calcStrikeCount(answer, "753")).isEqualTo(1);
            assertThat(Application.calcStrikeCount(answer, "132")).isEqualTo(1);
            assertThat(Application.calcStrikeCount(answer, "321")).isEqualTo(1);
            assertThat(Application.calcStrikeCount(answer, "213")).isEqualTo(1);
        }

        @Test
        @DisplayName("스트라이크 2개인 경우 테스트(같은 수가 같은 자리에 있는 숫자의 개수 2개)")
        void calcStrikeCount_matchTwo_Return2() {
            String answer = "123";
            assertThat(Application.calcStrikeCount(answer, "125")).isEqualTo(2);
            assertThat(Application.calcStrikeCount(answer, "183")).isEqualTo(2);
            assertThat(Application.calcStrikeCount(answer, "923")).isEqualTo(2);
        }

        @Test
        @DisplayName("스트라이크 3개인 경우 테스트(같은 수가 같은 자리에 있는 숫자의 개수 3개)")
        void calcStrikeCount_matchThree_Return3() {
            String answer = "123";
            assertThat(Application.calcStrikeCount(answer, "123")).isEqualTo(3);
        }

        @Test
        @DisplayName("볼 1개인 경우 테스트(같은 수가 다른 자리에 있는 숫자의 개수 1개)")
        void calcBallCount_matchOne_Return1() {
            String answer = "123";
            assertThat(Application.calcBallCount(answer, "451")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "617")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "289")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "482")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "356")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "738")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "138")).isEqualTo(1);
            assertThat(Application.calcBallCount(answer, "172")).isEqualTo(1);
        }

        @Test
        @DisplayName("볼 2개인 경우 테스트(같은 수가 다른 자리에 있는 숫자의 개수 2개)")
        void calcBallCount_matchTwo_Return2() {
            String answer = "123";
            assertThat(Application.calcBallCount(answer, "281")).isEqualTo(2);
            assertThat(Application.calcBallCount(answer, "371")).isEqualTo(2);
            assertThat(Application.calcBallCount(answer, "239")).isEqualTo(2);
            assertThat(Application.calcBallCount(answer, "213")).isEqualTo(2);
            assertThat(Application.calcBallCount(answer, "321")).isEqualTo(2);
            assertThat(Application.calcBallCount(answer, "132")).isEqualTo(2);
        }

        @Test
        @DisplayName("볼 3개인 경우 테스트(같은 수가 다른 자리에 있는 숫자의 개수 3개)")
        void calcBallCount_matchThree_Return3() {
            String answer = "123";
            assertThat(Application.calcBallCount(answer, "312")).isEqualTo(3);
            assertThat(Application.calcBallCount(answer, "231")).isEqualTo(3);
        }
    }

    @Nested
    class PrintGuessResultTest {
        @Test
        @DisplayName("스트라이크만 있을 경우 출력")
        void printGuessResult_StrikeOnly_Print() {
            OutputStream os = new ByteArrayOutputStream();

            System.setOut(new PrintStream(os));
            Application.printGuessResult(1, 0);
            assertThat(os.toString().strip()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("볼만 있을 경우 출력")
        void printGuessResult_BallOnly_Print() {
            OutputStream os = new ByteArrayOutputStream();

            System.setOut(new PrintStream(os));
            Application.printGuessResult(0, 2);
            assertThat(os.toString().strip()).isEqualTo("2볼");
        }

        @Test
        @DisplayName("스트라이크와 볼이 있을 경우 출력")
        void printGuessResult_StrikeAndBall_Print() {
            OutputStream os = new ByteArrayOutputStream();

            System.setOut(new PrintStream(os));
            Application.printGuessResult(1, 1);
            assertThat(os.toString().strip()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        @DisplayName("스트라이크와 볼이 없을 경우 출력")
        void printGuessResult_NonStrikeAndBall_Print() {
            OutputStream os = new ByteArrayOutputStream();

            System.setOut(new PrintStream(os));
            Application.printGuessResult(0, 0);
            assertThat(os.toString().strip()).isEqualTo("낫싱");
        }
    }

    @Nested
    class IsContinueTest {
        @Test
        @DisplayName("기본흐름: 1을 눌러 게임 새로 시작하는 경우")
        void isContinue_ValidInput1_True() {
            String playerInput = "1";
            InputStream is = new ByteArrayInputStream(playerInput.getBytes());

            System.setIn(is);
            assertThat(Application.isContinue()).isEqualTo(true);
        }

        @Test
        @DisplayName("기본흐름: 2를 눌러 게임을 완전히 종료하는 경우")
        void isContinue_ValidInput2_False() {
            String playerInput = "2";
            InputStream is = new ByteArrayInputStream(playerInput.getBytes());

            System.setIn(is);
            assertThat(Application.isContinue()).isEqualTo(false);
        }

        @Test
        @DisplayName("예외흐름: 올바른 명령어를 입력하지 않은 경우")
        void isContinue_InValidInput_IllegalArgumentExceptionThrown() {
            String playerInput = "종료";
            InputStream is = new ByteArrayInputStream(playerInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(Application::isContinue)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
