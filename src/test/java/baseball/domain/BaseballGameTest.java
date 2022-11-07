package baseball.domain;

import static baseball.domain.ComputerTest.*;
import static baseball.global.exception.CustomException.INVALID_DATA_TYPE;
import static baseball.global.exception.CustomException.INVALID_THREE_DIGIT;
import static baseball.global.exception.CustomException.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    Computer computer;
    Score score;
    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        // given
        computer = Computer.of();
        score = Score.of();
        baseballGame = BaseballGame.builder()
                .computer(computer)
                .score(score)
                .build();
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

}
