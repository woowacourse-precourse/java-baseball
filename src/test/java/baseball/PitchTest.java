package baseball;

import baseball.core.Pitch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PitchTest {
    @Test
    void constructor_test() {
        Pitch pitch = new Pitch();
        assertThat(pitch.toString()).isEqualTo("123");
    }
    @Test
    void random_test() {
        Pitch pitch = new Pitch().random();
        String pitchString = pitch.toString();
        assertThat(pitchString.length()).isEqualTo(3);
        assertThat(pitchString.matches("[1-9]+")).isEqualTo(true);
    }
    @Test
    void update_valid_string_test() {
        Pitch pitch = new Pitch();
        pitch.update("234");
        assertThat(pitch.toString()).isEqualTo("234");
    }
    @Test
    void update_invalid_string_test() {
        Pitch pitch = new Pitch();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> pitch.update("23a"));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        exception = assertThrows(IllegalArgumentException.class, () -> pitch.update("23"));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        exception = assertThrows(IllegalArgumentException.class, () -> pitch.update("2443"));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        exception = assertThrows(IllegalArgumentException.class, () -> pitch.update("120"));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        exception = assertThrows(IllegalArgumentException.class, () -> pitch.update(""));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        exception = assertThrows(IllegalArgumentException.class, () -> pitch.update("abc"));
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void compare_test() {
        Pitch actualPitch = new Pitch(); // default is "123"
        Pitch guessPitch = new Pitch();
        guessPitch.update("345");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("1볼");
        guessPitch.update("234");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("2볼");
        guessPitch.update("231");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("3볼");
        guessPitch.update("134");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("1볼 1스트라이크");
        guessPitch.update("321");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("2볼 1스트라이크");
        guessPitch.update("893");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("1스트라이크");
        guessPitch.update("923");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("2스트라이크");
        guessPitch.update("123");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("3스트라이크");
        guessPitch.update("456");
        assertThat(actualPitch.compareTo(guessPitch).toString()).isEqualTo("낫싱");
    }
}
