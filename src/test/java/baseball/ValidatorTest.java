package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.spy;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("사용자 입력값 검증 통과")
    void validateInput() {
        String userInput = "123";
        Validator validator1 = spy(validator);

        validator1.validateInput(userInput);

        then(validator1).should(times(1)).validateInput(userInput);
    }

    @Test
    @DisplayName("사용자의 중복된 값 입력으로 인한 입력값 검증 실패")
    void validateInputFail1() {
        String userInput = "111";

        assertThatThrownBy(() -> validator.validateInput(userInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Const.INPUT_WITHOUT_OVERLAP);
    }

    @Test
    @DisplayName("사용자의 숫자 아닌 값 입력으로 인한 입력값 검증 실패")
    void validateInputFail2() {
        String userInput = "1a3";

        assertThatThrownBy(() -> validator.validateInput(userInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Const.ONLY_NUMBER);
    }

    @Test
    @DisplayName("사용자의 짧은 값으로 인한 입력값 검증 실패")
    void validateInputFail3() {
        String userInput = "12";

        assertThatThrownBy(() -> validator.validateInput(userInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Const.INPUT_3_NUMBERS);
    }

    @Test
    @DisplayName("게임 재시작")
    void userWantRestart() {
        String restart = "1";

        assertThat(validator.userWantRestart(restart)).isTrue();
    }

    @Test
    @DisplayName("게임 종료")
    void userWantFinish() {
        String finish = "2";

        assertThat(validator.userWantRestart(finish)).isFalse();
    }

    @Test
    @DisplayName("재시작 / 종료 이외의 값 입력으로 인한 오류")
    void userInputInvalid() {
        String input = "3";

        assertThatThrownBy(() -> validator.userWantRestart(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Const.RESTART_1_FINISH_2);
    }

}