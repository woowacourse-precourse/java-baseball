package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class NumberBaseBallGameTest {
    @Test
    @DisplayName("정상 값 입력")
    void enter_Correct_InputNumber(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = mock(NumberBaseBallGame.class);
        doNothing().when(numberBaseBallGame).validateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("3자리 미만의 값 입력시 에러")
    void enter_LessThreeLength_InputNumber(){
        String inputNumber = "12";
        failValidateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("4자리 이상의 값 입력시 에러")
    void enter_OverFourLength_InputNumber(){
        String inputNumber = "1234";
        failValidateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("문자가 포함된 값 입력시 에러")
    void enter_InputNumber_WithString(){
        String inputNumber = "12s";
        failValidateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("입력값과 정답 동일 - 성공로직")
    void success(){
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(List.of(1,2,3));
        Map<String, Integer> result = numberBaseBallGame.checkResultPoint("123");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get("strike")).isEqualTo(3);
        assertThat(result.get("ball")).isNull();
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void has_Only_Ball(){
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(List.of(1,2,3));
        Map<String, Integer> result = numberBaseBallGame.checkResultPoint("231");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get("strike")).isNull();
        assertThat(result.get("ball")).isEqualTo(3);
    }

    @Test
    @DisplayName("볼과 스트라이크가 모두 있는 경우")
    void has_Ball_And_Strike(){
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(List.of(1,2,3));
        Map<String, Integer> result = numberBaseBallGame.checkResultPoint("132");

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get("strike")).isEqualTo(1);
        assertThat(result.get("ball")).isEqualTo(2);
    }

    @Test
    @DisplayName("전부 일치하지 않을 경우")
    void nothing(){
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(List.of(1,2,3));
        Map<String, Integer> result = numberBaseBallGame.checkResultPoint("456");

        assertThat(result.size()).isEqualTo(0);
        assertThat(result.get("strike")).isNull();
        assertThat(result.get("ball")).isNull();
    }

    private void failValidateInputNumber(String inputNumber) {
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(List.of(1,2,3));
        assertThatThrownBy(() -> numberBaseBallGame.validateInputNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3개의 자연수를 입력하세요");
    }
}