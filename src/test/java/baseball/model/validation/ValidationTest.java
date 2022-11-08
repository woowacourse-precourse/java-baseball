package baseball.model.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validation validation;

    @BeforeEach
    void beforeEach() {
        validation = new Validation();
    }

    @Test
    void 자리수_확인() {
        // given
        String over = "1234";
        String less = "12";
        String right = "123";

        // then
        assertThat(validation.isThreeDigits(over)).isEqualTo(false);
        assertThat(validation.isThreeDigits(less)).isEqualTo(false);
        assertThat(validation.isThreeDigits(right)).isEqualTo(true);
    }

    @Test
    void String_중복_체크() {
        // given
        String duplicate = "113";

        // then
        assertThat(validation.isDuplicateString(duplicate)).isEqualTo(true);
    }

    @Test
    void List_중복_체크() {
        // given
        List<Integer> list = new ArrayList<>(List.of(1, 1, 2));

        // then
        assertThat(validation.isDuplicateList(list)).isEqualTo(true);
    }

    @Test
    void 숫자인지_확인() {
        // given
        String number = "123";
        String alphabet = "a1c";
        String korean = "ㄱㄷㄹ";
        String etc = ":3=";

        // then
        assertThat(validation.isNumeric(number)).isEqualTo(true);
        assertThat(validation.isNumeric(alphabet)).isEqualTo(false);
        assertThat(validation.isNumeric(korean)).isEqualTo(false);
        assertThat(validation.isNumeric(etc)).isEqualTo(false);
    }

    @Test
    void ZERO_있는지_확인() {
        // given
        String hasZero = "102";

        // then
        assertThat(validation.hasZero(hasZero)).isEqualTo(true);
    }

    @Test
    void 입력_숫자_유효성_확인() {
        // given
        String inputLess = "1";
        String inputMore = "3124";
        String inputDuplicate = "424";
        String inputNotNumber = "k:#";
        String inputHasZero = "390";

        // then
        assertThatThrownBy(() -> {
            validation.isValidateInput(inputLess);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateInput(inputMore);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateInput(inputDuplicate);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateInput(inputNotNumber);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateInput(inputHasZero);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_유효성_확인() {
        // given
        String inputError = "3";
        String inputEmpty = "";
        String inputTwoDigit1 = "12";
        String inputTwoDigit2 = "21";

        //then
        assertThatThrownBy(() -> {
            validation.isValidateReplayInput(inputError);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateReplayInput(inputEmpty);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateReplayInput(inputTwoDigit1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation.isValidateReplayInput(inputTwoDigit2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}