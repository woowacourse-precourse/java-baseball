package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GenerateTest {

    @Test
    void radomNumber_랜덤_숫자_길이_확인() {
        int input = 3;

        assertThat(Generate.randomNumber().size()).isEqualTo(input);
    }

    @Test
    void randomNumber_랜덤_숫자_범위_확인() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> random = Generate.randomNumber();
            List<String> input = new ArrayList<>();
            for (int number : random) {
                input.add(String.valueOf(number));
            }

            assertThat(Integer.valueOf(String.join("", input))).isBetween(111, 999);
        }
    }
}
