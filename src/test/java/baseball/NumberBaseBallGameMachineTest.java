package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallGameMachineTest {
    @DisplayName("올바른 3개의 숫자 입력값")
    @Test
    void getProperNumberInput() {
        //given
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when
        gameMachine.validateThreeNumbers("856");
        gameMachine.validateThreeNumbers("293");
        //then (pass)
    }

    @DisplayName("오류 테스트 - 숫자값 입력 검증 (입력값이 적음)")
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

    @DisplayName("오류 테스트 - 숫자값 입력 검증 (입력값이 많음)")
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


    @DisplayName("오류 테스트 - 숫자값 입력 검증 (숫자가 아닌 입력값)")
    @Test
    void getNonNumberInput() {
        //given
        String input = "1 3";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 입력값이 존재합니다.");
    }

    @DisplayName("오류 테스트 - 숫자값 입력 검증 (중복 입력값)")
    @Test
    void getDuplicateNumberInput() {
        //given
        String input = "122";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("오류 테스트 - 숫자값 입력 검증 (숫자 0이 존재)")
    @Test
    void getNumberZeroInInput() {
        //given
        String input = "102";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1에서 9사이의 입력값만 유효합니다.");
    }

    @DisplayName("올바른 새게임 진행 여부 입력값")
    @Test
    void getProperNewGameInput() {
        //given
        String input = "1";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when
        gameMachine.validateNewGameInput(input);
        //then
    }

    @DisplayName("오류 테스트 - 새 게임 여부 입력 검증 (입력값이 적음)")
    @Test
    void getLessNewGameInput() {
        //given
        String input = "";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateNewGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 부족합니다. (1개 필요)");
    }

    @DisplayName("오류 테스트 - 새 게임 여부 입력 검증 (입력값이 많음)")
    @Test
    void getMoreNewGameInput() {
        //given
        String input = "123";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateNewGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 너무 많습니다. (1개 필요)");
    }

    @DisplayName("오류 테스트 - 새 게임 여부 입력 검증(입력값이 1, 2가 아님)")
    @Test
    void getNot1Or2NewGameInput() {
        //given
        String input = "3";
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when, then
        assertThatThrownBy(() -> gameMachine.validateNewGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 1이나 2가 아닙니다.");
    }

    @DisplayName("메시지 출력 기능 테스트")
    @Test
    void display() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        String message = "메시지 테스트 입니다";
        //when
        gameMachine.display(message);
        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(message);
    }

    @DisplayName("콘솔로 입력 기능 테스트")
    @Test
    void getInputLine() {
        //given
        String input = "콘솔로 입력합니다.";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when
        String inputResult = gameMachine.getInputLine();
        //then
        assertThat(input).isEqualTo(inputResult);
    }

    @DisplayName("숫자 3개 입력 기능 테스트")
    @Test
    void getThreeNumberInput() {
        //given
        String input = "312";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        NumberBaseBallGameMachine gameMachine = new NumberBaseBallGameMachine();
        //when
        List<Integer> numberList = gameMachine.getThreeNumberInput();
        //then
        assertThat(numberList.size()).isEqualTo(3);
        assertThat(numberList).contains(1, 2, 3);
    }
}