package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BallTest {

    @Nested
    @DisplayName("validateForm 메소드는")
    class validateForm_test {
        @Nested
        @DisplayName("세 자리 숫자가 입력되지 않았을 때")
        class Context_with_non_three_digit_number {
            @Test
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            void it_returns_IllegalArgumentException() {
                String twoDigitNumber = "12";

                assertThatThrownBy(() -> new Ball(twoDigitNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Ball.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
            }
        }
    }

    @Nested
    @DisplayName("validateDuplication 메소드는")
    class validateDuplication_test {
        @Nested
        @DisplayName("중복을 갖는 숫자가 입력되었을 때")
        class Context_with_duplicate_number {
            @Test
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            void it_returns_IllegalArgumentException() {
                String duplicateNumber = "333";

                assertThatThrownBy(() -> new Ball(duplicateNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Ball.EXCEPTION_MESSAGE_FOR_DUPLICATION);
            }
        }
    }

    @Test
    @DisplayName("toString 메소드가 String을 반환하는지 확인")
    void toString_test() {
        String nonDuplicateThreeDigitNumber = "123";
        Ball ball = new Ball(nonDuplicateThreeDigitNumber);

        String ballString = ball.toString();

        assertThat(ballString).isEqualTo(nonDuplicateThreeDigitNumber);
    }

    @Nested
    @DisplayName("compareByIndex 메소드는")
    class CompareByIndex_test {
        @Nested
        @DisplayName("각 숫자의 위치와 값이 동일한 Ball 인스턴스가 입력되었을 때")
        class Context_with_same_number_Ball_instance {
            @Test
            @DisplayName("3을 반환한다.")
            void it_returns_integer_vale_of_3() {
                String number = "123";
                Ball ball = new Ball(number);
                Ball sameNumberBall = new Ball(number);

                int countOfSameNumber = ball.compareByIndex(sameNumberBall);

                assertThat(countOfSameNumber).isEqualTo(3);
            }
        }

        @Nested
        @DisplayName("각 숫자의 위치와 값이 하나 다른 Ball 인스턴스가 입력되었을 때")
        class Context_with_different_one_number_Ball_instance {
            @Test
            @DisplayName("2를 반환한다.")
            void it_returns_integer_value_of_2() {
                String number = "123";
                String differentNumber = "124";
                Ball ball = new Ball(number);
                Ball differentNumberBall = new Ball(differentNumber);

                int countOfSameNumber = ball.compareByIndex(differentNumberBall);

                assertThat(countOfSameNumber).isEqualTo(2);
            }
        }
    }

    @Nested
    @DisplayName("compareByValue 메소드는")
    class compareByValue_test {
        @Nested
        @DisplayName("위치와 무관하게 숫자가 동일한 Ball 인스턴스가 입력되었을 때")
        class Context_with_same_number_Ball_instance {
            @Test
            @DisplayName("3을 반환한다.")
            void it_returns_integer_value_of_3() {
                String number = "123";
                String sameNumber = "312";
                Ball ball = new Ball(number);
                Ball sameBall = new Ball(sameNumber);

                int countOfSameNumber = ball.compareByValue(sameBall);

                assertThat(countOfSameNumber).isEqualTo(3);
            }
        }

        @Nested
        @DisplayName("위치와 무관하게 숫자가 하나 다른 Ball 인스턴스가 입력되었을 때")
        class Context_with_different_number_Ball_instance {
            @Test
            @DisplayName("2를 반환한다.")
            void it_returns_count_of_containing_number() {
                String number = "123";
                String differentNumber = "512";
                Ball ball = new Ball(number);
                Ball differentBall = new Ball(differentNumber);

                int countOfSameNumber = ball.compareByValue(differentBall);

                assertThat(countOfSameNumber).isEqualTo(2);
            }
        }
    }
}