package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    private Service service;

    @BeforeEach
    private void init() {
        service = new Service();
    }

    @DisplayName(value = "정상 3자리 숫자 입력 리스트 반환")
    @Test
    void inputValue() throws Exception {
        String input = "123";
        List<Integer> inputList = Arrays.asList(1, 2, 3);
        assertThat(service.parser(input))
                .isEqualTo(inputList);
    }

    @DisplayName(value = "중복 숫자 입력 예외")
    @Test
    void inputDuplicate() throws Exception {
        String input = "113";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.parser(input);
        });
    }

    @DisplayName(value = "공백 입력 예외")
    @Test
    void inputBlank() throws Exception {
        String input = "  ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.parser(input);
        });
    }

    @DisplayName(value = "문자 입력 예외")
    @Test
    void inputAlphabet() throws Exception {
        String input = "aaa";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.parser(input);
        });
    }

    @DisplayName(value = "3자리가 아닌 입력 예외")
    @Test
    void inputDigit() throws Exception {
        String input = "1111";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.parser(input);
        });
    }


}
