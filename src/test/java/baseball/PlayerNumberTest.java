package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNumberTest {
    @Test
    @DisplayName("입력값이 숫자인지 검증한다.")
    public void isOnlyDigit() {
        String number = "23ㅣ7";
        boolean isOnlyDigit = number.chars().allMatch(Character::isDigit);
        assertThat(isOnlyDigit).isFalse();
    }

    @Test
    @DisplayName("입력값이 숫자가 아니면 예외를 던진다.")
    public void validateIsOnlyDigit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String number = "23ㅣ7";
            PlayerNumber.validateIsOnlyDigit(number);
        }, "예외가 발생하지 않았습니다.");
    }

    @Test
    @DisplayName("입력값이 3자리 수인지 검증한다.")
    public void validateNumberLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String number = "20514";
            PlayerNumber.validateNumberLength(number);
        });
    }

    @Test
    @DisplayName("입력값이 1에서 9까지의 범위에 해당하는지 검증한다.")
    public void isOutOfRange() {
        String number = "307";
        boolean isOutOfRange = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n >= 1 && n <= 9))
                .count() != number.length();
        assertThat(isOutOfRange).isTrue();
    }

    @Test
    @DisplayName("입력값이 1에서 9까지의 범위를 벗어나면 예외를 던진다")
    public void validateNumberRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String number = "307";
            PlayerNumber.validateNumberRange(number);
        }, "예외가 발생하지 않았습니다.");
    }

    @Test
    @DisplayName("입력값에 중복된 숫자가 있는지 검증한다.")
    public void isDuplicated() {
        String number = "446";
        boolean isDuplicated = Arrays.stream(number.split(""))
                .distinct()
                .count() != number.length();
        assertThat(isDuplicated).isTrue();
    }

    @Test
    @DisplayName("입력값에 중복이 있으면 예외를 던진다.")
    public void validateDuplication() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String number = "446";
            PlayerNumber.validateDuplication(number);
        }, "예외가 발생하지 않았습니다.");
    }
}
