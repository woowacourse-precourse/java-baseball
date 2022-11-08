package baseball;

import baseball.inputException.ContainingZeroException;
import baseball.inputException.DuplicatedNumberException;
import baseball.inputException.IllegalDigitsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.inputException.ContainingZeroException.isContainingZero;
import static baseball.inputException.DuplicatedNumberException.confirmDuplicationNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("정상적인 Input 값을 받았을 때 사이즈가 3인 리스트를 받는다.")
    @Test
    void confirmInputValue() {
        List<Integer> userInput = getUserInputValue();
        assertThat(userInput.size()).isEqualTo(3);

    }

    @DisplayName("입력된 값이 3자리 수가 아닐 때 에러 확인")
    @Test
    void givenNotThreeDigits_whenConfirmInputValue_thenReturnIllegalDigitsException() {
        assertThatThrownBy(() -> givenWrongSituationGetUserInputValue("1234"))
                .isInstanceOf(IllegalDigitsException.class);
    }

    @DisplayName("3자리 수 중에서 중복된 값이 있을 때 에러 확인")
    @Test
    void givenDuplicatedNumber_whenConfirmInputValue_thenReturnDuplicatedNumberException() {
        assertThatThrownBy(() -> givenWrongSituationGetUserInputValue("122"))
                .isInstanceOf(DuplicatedNumberException.class);
    }

    @DisplayName("사용자가 입력한 수 중에서 0이 있을 때 에러 확인")
    @Test
    void givenContainingZeroNumber_whenConfirmInputValue_thenReturnContainingZeroException() {
        assertThatThrownBy(() -> givenWrongSituationGetUserInputValue("102"))
                .isInstanceOf(ContainingZeroException.class);
    }

    List<Integer> getUserInputValue() {

        List<Integer> userInput = new ArrayList<>();
        String input = "123";

        for (int i = 0; i < input.length(); i++) {
            userInput.add(input.charAt(i) - '0');
        }

        if (userInput.size() != 3)
            throw new IllegalDigitsException();
        if (!confirmDuplicationNumber(userInput))
            throw new DuplicatedNumberException();
        if (isContainingZero(userInput))
            throw new ContainingZeroException();

        return userInput;
    }

    List<Integer> givenWrongSituationGetUserInputValue(String input) {

        List<Integer> userInput = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            userInput.add(input.charAt(i) - '0');
        }

        if (userInput.size() != 3)
            throw new IllegalDigitsException();
        if (!confirmDuplicationNumber(userInput))
            throw new DuplicatedNumberException();
        if (isContainingZero(userInput))
            throw new ContainingZeroException();

        return userInput;
    }


}