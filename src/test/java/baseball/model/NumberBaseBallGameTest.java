package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

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
    @DisplayName("결과값 확인 - 스트라이크")
    void check_Result_Only_Strike(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(new GameNumber(Set.of(1, 2, 3)));
        Result result = numberBaseBallGame.result(inputNumber);

        assertThat(result.hasBallAndStrike()).isFalse();
        assertThat(result.hasStrike()).isTrue();
        assertThat(result.hasBall()).isFalse();
        assertThat(result.isFinish()).isTrue();
        assertThat(result.getEachCount().get("strike")).isEqualTo(3);
        assertThat(result.getEachCount().get("ball")).isEqualTo(0);
    }

    @Test
    @DisplayName("결과값 확인 - 볼")
    void check_Result_Only_Ball(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(new GameNumber(Set.of(2, 3, 1)));
        Result result = numberBaseBallGame.result(inputNumber);

        assertThat(result.hasBallAndStrike()).isFalse();
        assertThat(result.hasStrike()).isFalse();
        assertThat(result.hasBall()).isTrue();
        assertThat(result.isFinish()).isFalse();
        assertThat(result.getEachCount().get("strike")).isEqualTo(0);
        assertThat(result.getEachCount().get("ball")).isEqualTo(3);
    }

    @Test
    @DisplayName("결과값 확인 - 볼, 스트라이크")
    void check_Result_Ball_Strike(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(new GameNumber(Set.of(1, 3, 2)));
        Result result = numberBaseBallGame.result(inputNumber);

        assertThat(result.hasBallAndStrike()).isTrue();
        assertThat(result.hasStrike()).isTrue();
        assertThat(result.hasBall()).isTrue();
        assertThat(result.isFinish()).isFalse();
        assertThat(result.getEachCount().get("strike")).isEqualTo(1);
        assertThat(result.getEachCount().get("ball")).isEqualTo(2);
    }

    @Test
    @DisplayName("결과값 확인 - 낫싱")
    void check_Result_Nothing(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(new GameNumber(Set.of(4, 5, 6)));
        Result result = numberBaseBallGame.result(inputNumber);

        assertThat(result.hasBallAndStrike()).isFalse();
        assertThat(result.hasStrike()).isFalse();
        assertThat(result.hasBall()).isFalse();
        assertThat(result.isFinish()).isFalse();
        assertThat(result.getEachCount().get("strike")).isEqualTo(0);
        assertThat(result.getEachCount().get("ball")).isEqualTo(0);
    }

    private void failValidateInputNumber(String inputNumber) {
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(new GameNumber(Set.of(1, 2, 3)));
        assertThatThrownBy(() -> numberBaseBallGame.validateInputNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3개의 자연수를 입력하세요");
    }
}