package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorUtilTest {

    @Test
    @DisplayName("Computer는 서로 다른 3개의 숫자를 만들 수 있다")
    void testComputerMakesThreeDifferentNumber() throws Exception {
        //given
        List<Integer> numberList = RandomNumberGeneratorUtil.makesDifferenceThreeNumber();

        //when
        Set<Integer> numberSet = new HashSet<>(numberList);

        //then
        assertThat(numberSet.size()).isEqualTo(3);
    }
}