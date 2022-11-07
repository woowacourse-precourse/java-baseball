package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckerTest {

    Checker checker = new Checker();

    @Test
    @DisplayName("사용자가 맞췄는지 확인")
    void isUserGuessRight() {
        String counterpartInput = "123";
        String userInput = "123";

        assertThat(
            checker.isUserGuessRight(makeOverlapChecker(counterpartInput), userInput, counterpartInput)).isTrue();
    }

    @Test
    @DisplayName("사용자가 틀렸는지 확인")
    void isUserGuessWrong() {
        String counterpartInput = "123";
        String userInput = "456";

        assertThat(
            checker.isUserGuessRight(makeOverlapChecker(counterpartInput), userInput, counterpartInput)).isFalse();
    }

    private Set<Character> makeOverlapChecker(String counterpartInput) {
        Set<Character> overlapChecker = new HashSet<>();
        for (char c : counterpartInput.toCharArray()) {
            overlapChecker.add(c);
        }
        return overlapChecker;
    }

}