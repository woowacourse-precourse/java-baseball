package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckerTest {

    Checker checker = new Checker();

    @Test
    @DisplayName("사용자가 맞췄는지 확인")
    void isUserGuessRight() {
        String counterpartInput = "123";
        String userInput = "123";

        assertThat(checker.isUserGuessRight(userInput, counterpartInput)).isTrue();
    }

    @Test
    @DisplayName("사용자가 틀렸는지 확인")
    void isUserGuessWrong() {
        String counterpartInput = "123";
        String userInput = "456";

        assertThat(checker.isUserGuessRight(userInput, counterpartInput)).isFalse();
    }

}