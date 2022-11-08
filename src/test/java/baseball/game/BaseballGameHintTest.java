package baseball.game;

import baseball.user.UserInput;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballGameHintTest extends NsTest {

    public void runMain() {}

    @Test
    @DisplayName("스트라이크와 볼 출력")
    void getHintStrikeAndBall(){
        String resultOutput="1볼 1스트라이크";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 1, 3);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("스트라이크만 출력")
    void getHintOnlyStrike(){
        String resultOutput="2스트라이크";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 4);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("볼만 출력")
    void getHintOnlyBall(){
        String resultOutput="2볼";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(3, 2, 4);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("낫싱 출력")
    void getHintNothing(){
        String resultOutput="낫싱";
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(7, 8, 9);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("정답일때 true 반환")
    void isAnswerTrue(){
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 5);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertTrue(baseballGameHint.isAnswer());
    }

    @Test
    @DisplayName("정답이 아닐때 false 반환")
    void isAnswerFalse(){
        BaseballGameHint baseballGameHint = new BaseballGameHint();
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testInput = List.of(2, 3, 1);

        baseballGameHint.getHint(testHiddenNumberList,testInput);

        assertFalse(baseballGameHint.isAnswer());
    }

    static class UserInputTest{

        @Test
        @DisplayName("사용자 입력 테스트")
        void inputNumberTrue() {
            UserInput userInput = new UserInput();

            String testInput = "234";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertThat(userInput.inputNumber()).isEqualTo(testInput);;
        }

        @Test
        @DisplayName("정수가 아닌 값을 입력받았을 때")
        void inputNumberIsNotInteger() {
            UserInput userInput = new UserInput();

            String testInput = "23j";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertSimpleTest(() ->
                            assertThatThrownBy(() -> userInput.inputNumber())
                                    .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessageContaining("숫자만 입력 가능합니다."));
        }

        @Test
        @DisplayName("세자리가 아닌 값을 입력받았을 때")
        void inputNumberIsNotThreeLength() {
            UserInput userInput = new UserInput();

            String testInput = "2346";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> userInput.inputNumber())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("세자리 수만 입력 가능합니다."));
        }

        @Test
        @DisplayName("입력값에 0 이 들어있을때")
        void inputNumberHaveZero() {
            UserInput userInput = new UserInput();

            String testInput = "204";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> userInput.inputNumber())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("1~9사이의 값만 입력 가능합니다."));
        }

        @Test
        @DisplayName("입력값에 중복이 있을때")
        void inputNumberIsDuplication() {
            UserInput userInput = new UserInput();

            String testInput = "233";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> userInput.inputNumber())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("중복은 입력할 수 없습니다."));
        }

        @Test
        @DisplayName("사용자 재시작 입력 테스트")
        void inputRestartOrStopTrue() {
            UserInput userInput = new UserInput();

            String testInput = "1";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertThat(userInput.inputRestartOrStop()).isEqualTo(testInput);;
        }

        @Test
        @DisplayName("사용자 재시작 입력 테스트 오류")
        void inputRestartOrStopFalse() {
            UserInput userInput = new UserInput();

            String testInput = "3";
            final byte[] buf = testInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> userInput.inputRestartOrStop())
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("숫자 1, 2만 입력할 수 있습니다."));
        }
    }
}