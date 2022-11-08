package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestControllerTest {

    @Test
    @DisplayName("validate and get List<Integer>")
    void validateAndGetIntListSuccessTest() {
        // given
        String inputString = "256";
        List<Integer> inputList = inputString.chars().mapToObj(i -> i - '0').collect(Collectors.toList());

        // when
        List<Integer> result = RequestController.validateAndGetIntList(inputString);

        // then
        assertThat(result).isEqualTo(inputList);
    }

    @Test
    @DisplayName("validate and get IllegalArgumentException")
    void validateAndGetIntListFailTest() {
        // given
        String[] invalidCases = new String[]{"abc", "133", "1234", "12", "8", "!)*", "012"};

        for (String invalidCase : invalidCases) {
            // then
            assertThatThrownBy(() -> RequestController.validateAndGetIntList(invalidCase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력값 입니다. 중복되지 않는 3자리의 정수를 입력해주세요");
        }
    }
}