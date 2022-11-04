package baseball;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {
    @Nested
    class Ball_class_test {
        @Nested
        @DisplayName("생성자, validateForm 메소드는")
        class validateFormTest {
            @Nested
            @DisplayName("세 자리 숫자가 입력되지 않았을 때")
            class Context_with_non_three_digit_number {
                @Test
                @DisplayName("IllegalArgumentException을 발생시킨다.")
                void it_returns_IllegalArgumentException() {
                    String twoDigitNumber = "12";
                    assertThatThrownBy(()-> new Ball(twoDigitNumber)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }

        @Nested
        @DisplayName("생성자, validateDuplication 메소드는")
        class validateDuplicationTest {
            @Nested
            @DisplayName("중복을 갖는 숫자가 입력되었을 때")
            class Context_with_duplicated_number {
                @Test
                @DisplayName("IllegalArgumentException을 발생시킨다.")
                void it_returns_IllegalArgumentException() {
                    String duplicatedNumber = "333";
                    assertThatThrownBy(()-> new Ball(duplicatedNumber)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }
    }
}