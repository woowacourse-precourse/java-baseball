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

@DisplayName("BaseballNumber 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumberTest {
    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_1과_9사이의_값을_입력받으면 {

            @Test
            void BaseballNumber_객체를_반환한다() {
                for (int i = BASEBALL_NUMBER_LOWER_BOUND; i < BASEBALL_NUMBER_UPPER_BOUND; i++) {
                    assertThat(BaseballNumber.valueOf(i)).isInstanceOf(BaseballNumber.class);
                }
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
