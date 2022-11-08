package baseball.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    void 사용자_정답_입력값의_길이는_3이다(){
        String playerInput1 = "12";
        String playerInput2 = "1234";

        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_정답_입력값의_범위는_1부터_9까지의_정수이다(){
        String playerInput1 = "abc";
        String playerInput2 = "1 2";
        String playerInput3 = "012";

        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_정답_입력값은_중복해선_안된다(){
        String playerInput1= "111";
        String playerInput2 = "112";
        String playerInput3 = "131";

        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(playerInput3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력값은_1_또는_2_이다(){
        String restartInput1= "3";
        String restartInput2 = "aaa";
        String restartInput3 = " ";

        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(restartInput1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(restartInput2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        validator.validatePlayerInputs(restartInput3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}