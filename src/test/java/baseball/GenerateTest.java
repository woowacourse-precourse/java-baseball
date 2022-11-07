package baseball;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class GenerateTest {
    private static final int LOOP_COUNT = 1000;

    @Test
    void radomNumber_랜덤_숫자_길이_확인() {
        int input = 3;

        assertThat(Generate.randomNumber().size()).isEqualTo(input);
    }

    @Test
    void randomNumber_랜덤_숫자_범위_확인() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            List<Integer> random = Generate.randomNumber();
            List<String> input = new ArrayList<>();
            for (int number : random) {
                input.add(String.valueOf(number));
            }
            assertThat(Integer.valueOf(String.join("", input))).isBetween(111, 999);
        }
    }

    @Test
    void randomNumber_랜덤_숫자_유일한지_확인() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            List<Integer> random = Generate.randomNumber();
            Set<Integer> input = new HashSet<>();
            input.addAll(random);
            assertThat(input.size()).isEqualTo(3);
        }
    }
}
