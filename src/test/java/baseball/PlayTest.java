package baseball;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = { "", "12", "3456", "788", "9a8", "$76" })
    void getNumberFrom_throws_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> Play.getNumberFrom(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}