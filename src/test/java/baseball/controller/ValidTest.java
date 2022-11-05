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
        List<Integer> includeZeroNumList2 = Arrays.asList(1, 0,2);
        List<Integer> includeZeroNumList3 = Arrays.asList(0, 1,2);
        //when
        boolean notValid = Valid.isValidNumList(includeZeroNumList);
        boolean notValid2 = Valid.isValidNumList(includeZeroNumList2);
        boolean notValid3 = Valid.isValidNumList(includeZeroNumList3);
        //then
        assertThat(notValid).isEqualTo(false);
        assertThat(notValid2).isEqualTo(false);
        assertThat(notValid3).isEqualTo(false);
    }

    @Test
    void 중복된숫자가있는경우(){
        //given
        List<Integer> includeZeroNumList = Arrays.asList(1, 2, 2);
        //when
        boolean notValid = Valid.isValidNumList(includeZeroNumList);
        //then
        assertThat(notValid).isEqualTo(false);
    }
}