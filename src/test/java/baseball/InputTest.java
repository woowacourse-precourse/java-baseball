package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    @DisplayName("정상 값")
    void create() {
        //given
        //when
        Input input = new Input("123");
        //then
        assertThat(input.getInput()).isEqualTo(123);
    }

    @Test
    @DisplayName("잘못된 길이")
    void createInvalidNumber() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("1234"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("12"));
    }

    @Test
    @DisplayName("겹치는 수 입력")
    void createDuplicateNumber() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("112"));
    }
}