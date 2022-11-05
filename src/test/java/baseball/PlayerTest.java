package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void playerAnswerSizeShouldBeThree() {
        Player player = new Player();
        List<String> playerAnswer = List.of("1234".split(""));
        assertThatThrownBy(() -> player.validate(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeNumber() {
        Player player = new Player();
        List<String> playerAnswer = List.of("abc".split(""));
        assertThatThrownBy(() -> player.validate(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeNonZero() {
        Player player = new Player();
        List<String> playerAnswer = List.of("012".split(""));
        assertThatThrownBy(() -> player.validate(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void playerAnswerDigitsShouldBeDistinct() {
        Player player = new Player();
        List<String> playerAnswer = List.of("112".split(""));
        assertThatThrownBy(() -> player.validate(playerAnswer))
                .isInstanceOf(IllegalArgumentException.class);
    }
}