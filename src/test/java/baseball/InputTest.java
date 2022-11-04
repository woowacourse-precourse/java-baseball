package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

class InputTest {
    @Test
    @DisplayName("정상 값")
    void getInput() {
        //given
        //when
        Input input = new Input("123");
        //then
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(input.getInputList()).isEqualTo(list);
    }

    @Test
    @DisplayName("잘못된 길이")
    void CheckLength() {
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
    void CheckContinuous() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("112"));
    }

    @Test
    @DisplayName("잘못된 입력 범위")
    void CheckLange() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("012"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("890"));
    }
}