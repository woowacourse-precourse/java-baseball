package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputValidatorTest {

    @Test
    @DisplayName("예외케이스: 입력받은 숫자의 길이가 3이 아닌 경우")
    public void 예외케이스_입력받은_숫자의_길이가_3이_아닌_경우() {

        String input = "1234";
        assertThatThrownBy(() -> {
            UserInputValidator.validateUserInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외케이스: 입력받은 값에 숫자가 아닌 값이 들어있는 경우")
    public void 예외케이스_입력받은_값에_숫자가_아닌_값이_들어있는_경우(){

        String input = "12#";
        assertThatThrownBy(() -> {
            UserInputValidator.validateUserInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외케이스: 입력받은 값에 서로 같은 값이 들어있는 경우")
    public void 예외케이스_입력받은_값에_서로_같은_값이_들어있는_경우(){

        String input = "122";
        assertThatThrownBy(() -> {
            UserInputValidator.validateUserInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
