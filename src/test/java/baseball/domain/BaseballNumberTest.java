package baseball.domain;

import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_LOWER_BOUND;
import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BaseballNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumberTest {

    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_1과_9사이의_값을_입력받으면 {

            @ParameterizedTest
            @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
            void BaseballNumber_객체를_리턴한다(int number) {
                assertThat(BaseballNumber.valueOf(number)).isInstanceOf(BaseballNumber.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_높은_값을_입력받으면 {
            private final Integer givenNumber = BASEBALL_NUMBER_UPPER_BOUND + 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> BaseballNumber.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_낮은_값을_입력받으면 {
            private final Integer givenNumber = BASEBALL_NUMBER_LOWER_BOUND - 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> BaseballNumber.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }
}
