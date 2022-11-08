package baseball;


import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MultiDigitNumberTest {

    @Nested
    @DisplayName("MultiDigitNumber 객체 생성자는 사용자로부터 숫자를 입력받아 객체를 생성하는데,")
    class describe_multiDigitNumber_constructor {

        @Nested
        @DisplayName("입력으로 주어지는 숫자는")
        class describe_argument_of_constructor {

            @Test
            @DisplayName("3자리 수여야 한다.")
            void validate_filtering_number_not_3digit_number() {
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(1, 2, 3, 4))
                    .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("각 자리수가 중복되면 안된다.")
            void validate_filtering_number_has_duplicate_digit() {
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(1, 1, 2))
                    .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("각 자리수는 1-9사이의 값을 가져야 한다.")
            void validate_filtering_number_has_digit_outOfRange() {
                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(1, 0, 2))
                    .isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(0, 1, 2))
                    .isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> new MultiDigitNumber(9, 6, 0))
                    .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("주어진 조건을 만족하는 경우에만 생성이 가능하다.")
            void validate_approve_generateInstance_when_number_satisfying_allCondition() {
                for (int i = 0; i < 1000; i++) {
                    boolean flag = true;

                    try {
                        if (!MultiDigitNumber.validateConsistOfThreeDigit(i) ||
                            !MultiDigitNumber.validateEachSingleDigitIsNotDuplicate(
                                Stream.of(String.valueOf(i).split("")).toArray(Integer[]::new))) {

                            flag = false;
                        }
                    } catch (IllegalArgumentException e) {
                        flag = false;
                    }

                    if (flag) {
                        new MultiDigitNumber(i);
                    } else {
                        int finalI = i;
                        Assertions.assertThatThrownBy(() -> new MultiDigitNumber(finalI))
                            .isInstanceOf(IllegalArgumentException.class);
                    }
                }
            }
        }
    }

    @Nested
    @DisplayName("getStrike 메서드는")
    class describe_getStrike {

        @Test
        @DisplayName("입력받은 또다른 MultiDigitNumber 객체와의 strike 개수를 반환한다.")
        void validate_returns_numberOf_Strike() {
            MultiDigitNumber multiDigitNumber = new MultiDigitNumber(1, 2, 3);

            Assertions.assertThat(multiDigitNumber.getStrike(new MultiDigitNumber(1, 4, 5)))
                .isEqualTo(1);
            Assertions.assertThat(multiDigitNumber.getStrike(new MultiDigitNumber(3, 2, 1)))
                .isEqualTo(1);
            Assertions.assertThat(multiDigitNumber.getStrike(new MultiDigitNumber(4, 5, 6)))
                .isEqualTo(0);
            Assertions.assertThat(multiDigitNumber.getStrike(new MultiDigitNumber(1, 2, 3)))
                .isEqualTo(3);
            Assertions.assertThat(multiDigitNumber.getStrike(new MultiDigitNumber(1, 4, 3)))
                .isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("getBall 메서드는")
    class describe_getBall {

        @Test
        @DisplayName("입력받은 또다른 MultiDigitNumber 객체와의 ball 개수를 반환한다.")
        void validate_returns_numberOf_Ball() {
            MultiDigitNumber multiDigitNumber = new MultiDigitNumber(1, 2, 3);

            Assertions.assertThat(multiDigitNumber.getBall(new MultiDigitNumber(4, 1, 5)))
                .isEqualTo(1);
            Assertions.assertThat(multiDigitNumber.getBall(new MultiDigitNumber(3, 2, 1)))
                .isEqualTo(2);
            Assertions.assertThat(multiDigitNumber.getBall(new MultiDigitNumber(4, 5, 6)))
                .isEqualTo(0);
            Assertions.assertThat(multiDigitNumber.getBall(new MultiDigitNumber(1, 2, 3)))
                .isEqualTo(0);
            Assertions.assertThat(multiDigitNumber.getBall(new MultiDigitNumber(1, 4, 3)))
                .isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("getCompareResult 메서드는")
    class describe_getCompareResult {

        @Test
        @DisplayName("비교 결과를 담은 CompareResult 객체를 반환한다.")
        void it_returns_CompareResult() {
            MultiDigitNumber multiDigitNumber = new MultiDigitNumber(1, 2, 3);

            Assertions.assertThat(
                    multiDigitNumber.getCompareResult(new MultiDigitNumber(3, 2, 1)).toString())
                .isEqualTo("2볼 1스트라이크");
            Assertions.assertThat(
                    multiDigitNumber.getCompareResult(new MultiDigitNumber(1, 4, 5)).toString())
                .isEqualTo("1스트라이크");
            Assertions.assertThat(
                    multiDigitNumber.getCompareResult(new MultiDigitNumber(5, 6, 1)).toString())
                .isEqualTo("1볼");
            Assertions.assertThat(
                    multiDigitNumber.getCompareResult(new MultiDigitNumber(8, 4, 7)).toString())
                .isEqualTo("낫싱");
        }
    }
}
