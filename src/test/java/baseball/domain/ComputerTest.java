package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int COUNT_VALUE = 3;


    @Test
    void createRandomNumber() {
        //given
        Computer computer = new Computer();

        //when
        computer.createRandomNumber();
        int[] result = computer.getAnswer();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < result.length; i++) {
            set.add(result[i]);
        }

        //then
        assertThat(result.length).isEqualTo(COUNT_VALUE);
        assertThat(set.size()).isEqualTo(result.length);
        for (int i = 0; i < COUNT_VALUE; i++) {
            assertThat(result[i]).isBetween(MIN_VALUE, MAX_VALUE);
        }

    }
}