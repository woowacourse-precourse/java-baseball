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
        List<Integer> includeDuplicateNumList1 = Arrays.asList(1, 2, 2);
        List<Integer> includeDuplicateNumList2 = Arrays.asList(2, 2, 2);
        List<Integer> includeDuplicateNumListIncludeZero = Arrays.asList(0, 2, 2);
        List<Integer> includeDuplicateNumListIncludeZero2 = Arrays.asList(0, 0, 0);
        //when
        boolean notValid1 = Valid.isValidNumList(includeDuplicateNumList1);
        boolean notValid2 = Valid.isValidNumList(includeDuplicateNumList2);
        boolean notValidIncludeZero1 = Valid.isValidNumList(includeDuplicateNumListIncludeZero);
        boolean notValidIncludeZero2 = Valid.isValidNumList(includeDuplicateNumListIncludeZero2);
        //then
        assertThat(notValid1).isEqualTo(false);
        assertThat(notValid2).isEqualTo(false);
        assertThat(notValidIncludeZero1).isEqualTo(false);
        assertThat(notValidIncludeZero2).isEqualTo(false);
    }

    @Test
    void numList크기가3이아닌경우() {
        //given
        List<Integer> numListSize0 = Arrays.asList();
        List<Integer> numListSize1 = Arrays.asList(1);
        List<Integer> numListSize2 = Arrays.asList(1,2);
        List<Integer> numListSize4 = Arrays.asList(1,2,4);
        //when
        boolean notValidSize0 = Valid.isValidNumList(numListSize0);
        boolean notValidSize1 = Valid.isValidNumList(numListSize1);
        boolean notValidSize2 = Valid.isValidNumList(numListSize2);
        boolean notValidSize3 = Valid.isValidNumList(numListSize4);
        //then
        assertThat(notValidSize0).isEqualTo(false);
        assertThat(notValidSize1).isEqualTo(false);
        assertThat(notValidSize2).isEqualTo(false);
        assertThat(notValidSize3).isEqualTo(false);
    }

}