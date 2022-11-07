package baseball;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {

    @RepeatedTest(10)
    void getRandomNumber_returns_unique_nonzero_digits() {
        List<Integer> randomNumber = Play.getRandomNumber();
        System.out.println(randomNumber);
        assertThat(randomNumber)
                .hasSize(Play.getCount())
                .isSubsetOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .doesNotHaveDuplicates();
    }
}