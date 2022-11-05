package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallGameMachineTest {

    @DisplayName("올바른 입력이 들어왔을 때 테스트")
    @Test
    void getProperNumberInput() {
        //given
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when
        gameMachine.validateThreeNumbers("856");
        gameMachine.validateThreeNumbers("293");
        //then (pass)
    }

    @DisplayName("오류 테스트 (입력값이 적음)")
    @Test
    void getLessNumberInput() {
        //given
        String input = "5";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 부족합니다. (3개 필요)");
    }

    @DisplayName("오류 테스트 (입력값이 많음)")
    @Test
    void getMoreNumberInput() {
        //given
        String input = "8523";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 너무 많습니다. (3개 필요, 중간 공백도 입력으로 판단)");
    }


    @DisplayName("오류 테스트 (숫자가 아닌 입력값)")
    @Test
    void getNonNumberInput() {
        //given
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers("1 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 입력값이 존재합니다.");
    }

    @DisplayName("오류 테스트 (중복 입력값)")
    @Test
    void getDuplicateNumberInput() {
        //given
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers("122"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("오류 테스트 (숫자 0이 존재)")
    @Test
    void getNumberZeroInInput() {
        //given
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers("102"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1에서 9사이의 입력값만 유효합니다.");
    }
}