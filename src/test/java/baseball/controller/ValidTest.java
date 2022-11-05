package baseball.controller;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidTest {

    @Test
    void 숫자가0이있는경우() {
        //given
        List<Integer> includeZeroNumList = Arrays.asList(1, 2, 0);
        //when
        boolean notValid = Valid.isValidNumList(includeZeroNumList);
        //then
        assertThat(notValid).isEqualTo(false);
    }
}