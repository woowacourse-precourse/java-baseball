package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class MethodTest {

    @Test
    void 컴퓨터의_random_number_생성() {
        ArrayList<Integer> randomNumbers = Application.getRandomNumbers();
        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers).doesNotHaveDuplicates();
        for (Integer i : randomNumbers)
            assertThat(i).isBetween(1, 9);
    }
}
