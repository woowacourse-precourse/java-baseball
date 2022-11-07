package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UsersTest {
    @Test
    void getInputList_123_123() {
        //given
        //when
        Users input = new Users("123");
        //then
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(input.getInputList()).isEqualTo(list);
    }

    @Test
    void CheckLength_InputLessThen3_ExceptionThrown() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("12"));
    }

    @Test
    void CheckLength_InputMoreThen3_ExceptionThrown() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("1234"));
    }

    @Test
    void CheckDuplicate_Input112_ExceptionThrown() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("112"));
    }

    @Test
    void CheckRange_OutOfRangeInput0_ExceptionThrown() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("012"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("890"));
    }
}