package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitsTest {
    @DisplayName("Digits 객체가 생성되고 사이즈는 0으로 초기화 됨")
    @Test
    void 생성_체크() {
        Digits digits = Digits.create();
        assertThat(digits.size()).isEqualTo(0);
        assertThrows(IllegalArgumentException.class, () -> digits.getDigitInIndex(0));
    }

    @DisplayName("숫자의 오른쪽에 값을 추가할 수 있다")
    @Test
    void 오른쪽_값_추가() {
        Digits digits = Digits.create();
        digits.append(Digit.FIVE);
        assertThat(digits.size()).isEqualTo(1);
        assertThat(digits.getDigitInIndex(0)).isEqualTo(Digit.FIVE);

        digits.append(Digit.FOUR);
        assertThat(digits.size()).isEqualTo(2);
        assertThat(digits.getDigitInIndex(0)).isEqualTo(Digit.FIVE);
        assertThat(digits.getDigitInIndex(1)).isEqualTo(Digit.FOUR);
    }

    @DisplayName("숫자의 왼쪽에 값을 추가할 수 있다")
    @Test
    void 왼쪽_값_추가() {
        Digits digits = Digits.create();
        digits.appendToLeft(Digit.FIVE);
        assertThat(digits.size()).isEqualTo(1);
        assertThat(digits.getDigitInIndex(0)).isEqualTo(Digit.FIVE);

        digits.appendToLeft(Digit.FOUR);
        assertThat(digits.size()).isEqualTo(2);
        assertThat(digits.getDigitInIndex(0)).isEqualTo(Digit.FOUR);
        assertThat(digits.getDigitInIndex(1)).isEqualTo(Digit.FIVE);
    }

    @DisplayName("숫자가 포함되어있는지를 확인할 수 있다")
    @Test
    void contains_체크() {
        Digits digits = Digits.create();
        assertThat(digits.contains(Digit.FIVE)).isEqualTo(false);
        digits.append(Digit.FIVE);
        assertThat(digits.contains(Digit.FIVE)).isEqualTo(true);
    }
}
