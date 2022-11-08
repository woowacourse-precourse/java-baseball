package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void playerAnswerSizeShouldBeThree() {
        List<String> playerAnswer = List.of("1234".split(""));
        Answer answer = new Answer();
        assertThatThrownBy(() -> answer.lengthThree(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeNumber() {
        List<String> playerAnswer = List.of("abc".split(""));
        Answer answer = new Answer();
        assertThatThrownBy(() -> answer.isNumberFromOneToNine(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeNonZero() {
        List<String> playerAnswer = List.of("012".split(""));
        Answer answer = new Answer();
        assertThatThrownBy(() -> answer.isNumberFromOneToNine(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeDistinct() {
        List<String> playerAnswer = List.of("112".split(""));
        Answer answer = new Answer();
        assertThatThrownBy(() -> answer.distinct(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }
}