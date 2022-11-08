package baseball.domain;

import static baseball.domain.ComputerTest.*;
import static baseball.global.exception.CustomException.INVALID_DATA_TYPE;
import static baseball.global.exception.CustomException.INVALID_THREE_DIGIT;
import static baseball.global.exception.CustomException.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.*;

import baseball.utils.TestUtils;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    Computer computer;
    Score score;
    BaseballGame baseballGame;

    ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        // given
        computer = Computer.of();
        score = Score.of();
        baseballGame = BaseballGame.builder()
                .computer(computer)
                .score(score)
                .build();
        output = TestUtils.setOutToByteArray();
    }

    @AfterEach
    void tearDown() {
        TestUtils.clearSetOutToByteArray(output);
    }

    @Test
    @DisplayName("init() 메서드 호출시 score, computer 클래스 init 호출 테스트")
    void init() {
        // when
        baseballGame.init();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        // then
        assertRandomNumbers(randomNumbers);  // random 3자리 1-9의 서로 다른 숫자
        assertThat(score.getBallCount()).isEqualTo(0);
        assertThat(score.getStrikeCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("userInput안에 숫자 이외에 문자가 있을시 IllegalArgumentException 예외 발생")
    void input_UserInput_When_has_Not_Number_In_UserInput_Then_IllegalArgumentException() {
        String userInput = "12a";
        assertThatThrownBy(() -> baseballGame.test(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATA_TYPE.getMessage());
    }

    @Test
    @DisplayName("userInput의 길이가 3보다 클 때 IllegalArgumentException 예외 발생")
    void input_UserInput_When_Length_Of_UserInput_Is_Bigger_3_Digits_Then_IllegalArgumentException() {
        String userInput = "1234";
        assertThatThrownBy(() -> baseballGame.test(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_THREE_DIGIT.getMessage());
    }

    @Test
    @DisplayName("userInput의 길이가 3보다 작을 때 IllegalArgumentException 예외 발생")
    void input_UserInput_When_Length_Of_UserInput_Is_Smaller_3_Digits_Then_IllegalArgumentException() {
        String userInput = "12";
        assertThatThrownBy(() -> baseballGame.test(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_THREE_DIGIT.getMessage());
    }

    @Test
    @DisplayName("userInput이 중복을 가질 때 IllegalArgumentException 예외 발생")
    void input_UserInput_When_Having_Duplication_Then_IllegalArgumentException() {
        String userInput = "111";
        assertThatThrownBy(() -> baseballGame.test(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_THREE_DIGIT.getMessage());
    }

    @Test
    @DisplayName("userInput이 유효하지 않은 범위인 0을 가질 때 IllegalArgumentException 예외 발생")
    void input_UserInput_When_Invalid_Range_Has_Zero_Then_IllegalArgumentException() {
        String userInput = "120";
        assertThatThrownBy(() -> baseballGame.test(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("2볼")
    void print_two_ball() {
        score.setScore(2, 0);
        baseballGame.printHintMessage();

        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo("2볼");
    }

    @Test
    @DisplayName("1스트라이크")
    void print_one_strike() {
        score.setScore(0, 1);
        baseballGame.printHintMessage();

        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void print_two_ball_one_strike() {
        score.setScore(2, 1);
        baseballGame.printHintMessage();

        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("1볼 2스트라이크")
    void print_one_ball_two_strike() {
        score.setScore(1, 2);
        baseballGame.printHintMessage();

        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo("1볼 2스트라이크");
    }

    @Test
    @DisplayName("낫싱")
    void print_nothing() {
        score.setScore(0, 0);
        baseballGame.printHintMessage();

        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo("낫싱");
    }

}
