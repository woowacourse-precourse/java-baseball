package baseball.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.model.request.UserInputRequest;
import java.util.List;
import org.junit.jupiter.api.Test;

class RequestValidatorTest {

    @Test
    void REQUEST_TYPE_VALIDATION_CHECK() {
        UserInputRequest testForValidInputPattern1 = new UserInputRequest(List.of('1', '2', '3', '4'));
        UserInputRequest testForValidInputPattern2 = new UserInputRequest(List.of('1', '2'));
        UserInputRequest testForValidInputPattern3 = new UserInputRequest(List.of('k', 's', 'w'));
        UserInputRequest testForValidInputPattern4 = new UserInputRequest(List.of('0', '0', '1'));

        assertAll(
                () -> assertThatThrownBy(() -> RequestValidator.inputValidation(testForValidInputPattern1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1~9까지의 숫자를 3번 입력해주세요."),
                () -> assertThatThrownBy(() -> RequestValidator.inputValidation(testForValidInputPattern2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1~9까지의 숫자를 3번 입력해주세요."),
                () -> assertThatThrownBy(() -> RequestValidator.inputValidation(testForValidInputPattern3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1~9까지의 숫자를 3번 입력해주세요."),
                () -> assertThatThrownBy(() -> RequestValidator.inputValidation(testForValidInputPattern4))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1~9까지의 숫자를 3번 입력해주세요.")
        );

    }

    @Test
    void DUPLICATE_VALIDATION_CHECK(){
        UserInputRequest testForDuplicate = new UserInputRequest(List.of('2', '2', '3'));
        assertThatThrownBy(() -> RequestValidator.inputValidation(testForDuplicate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 입력하면 안됩니다.");
    }

}