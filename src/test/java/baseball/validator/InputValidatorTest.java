package baseball.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void beforeEach() {
        inputValidator = new InputValidator();
    }

    @Test
    void validateNotInPlaying_1or2가_아닌_경우_Exception() {
        String choice = "3";
        assertSimpleTest(() -> assertThatThrownBy(() -> inputValidator.validateNotInPlaying(choice)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void validateNotInPlaying_1or2인_경우_nothing() {
        String choice = "1";
        assertSimpleTest(() -> assertThatCode(() -> {
            inputValidator.validateNotInPlaying(choice);
        }).doesNotThrowAnyException());
    }

    @Test
    void validateInPlaying_중복인경우_Exception() {
        List<Integer> userNumbers = List.of(3, 2, 3);
        assertSimpleTest(() -> assertThatThrownBy(() -> inputValidator.validateInPlaying(userNumbers)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void validateInPlaying_3자리가_아닌_경우_Exception() {
        List<Integer> userNumbers = List.of(2, 3);
        assertSimpleTest(() -> assertThatThrownBy(() -> inputValidator.validateInPlaying(userNumbers)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void validateInPlaying_올바른입력_Pass() {
        List<Integer> userNumbers = List.of(2, 3, 5);
        assertSimpleTest(() -> assertThatCode(() -> {
            inputValidator.validateInPlaying(userNumbers);
        }).doesNotThrowAnyException());
    }

    @Test
    void isInvalidCharacterInPlaying_범위밖의입력_Exception() {
        // a1c 가 입력된 상황 -> 49, 1, 51 로 정수 변환됨
        List<Integer> userNumbers = List.of(49, 1, 51);
        assertSimpleTest(() -> assertThatThrownBy(() -> inputValidator.validateCharacterInPlaying(userNumbers)).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void isInvalidCharacterInPlaying_범위내입력_Pass() {
        // 1 ~ 9 사이라면 모두 통과
        List<Integer> userNumbers = List.of(3, 1, 5, 1, 3, 4, 5, 3);
        assertSimpleTest(() -> assertThatCode(() -> {
            inputValidator.validateCharacterInPlaying(userNumbers);
        }).doesNotThrowAnyException());
    }
}