package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Strike 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StrikeTest {
    private final int STRIKE_LOWER_BOUND = 0;
    private final int STRIKE_UPPER_BOUND = 3;

    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_0과_3사이의_값을_입력받으면 {

            @ParameterizedTest
            @ValueSource(ints = {0, 1, 2, 3})
            void Strike_객체를_리턴한다(int count) {
                assertThat(Strike.valueOf(count)).isInstanceOf(Strike.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_높은_값을_입력받으면 {
            private final Integer givenNumber = STRIKE_UPPER_BOUND + 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> Strike.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_낮은_값을_입력받으면 {
            private final Integer givenNumber = STRIKE_LOWER_BOUND - 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> Strike.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }

    @Nested
    class isStrikeOut_메서드는 {

        @Nested
        class 만약_객체의_값이_3이라면 {
            private Strike givenStrike = Strike.valueOf(3);

            @Test
            void 참을_리턴한다() {
                assertThat(givenStrike.isStrikeOut()).isTrue();
            }
        }

        @Nested
        class 만약_객체의_값이_3이_아니라면 {
            private Strike givenStrike = Strike.valueOf(2);

            @Test
            void 참을_리턴한다() {
                assertThat(givenStrike.isStrikeOut()).isFalse();
            }
        }
    }

    @Nested
    class toString_메서드는 {

        @Nested
        class 만약_스트라이크_카운트가_0인_경우 {
            private Strike strike = Strike.valueOf(0);

            @Test
            void 빈_문자열을_리턴한다() {
                assertThat(strike.toString()).isEqualTo("");
            }

        }

        @Nested
        class 만약_스트라이크_카운트가_0이_아닌_경우 {

            @ParameterizedTest(name = "스트라이크 카운트가 {0}인 경우 {1}을 리턴한다")
            @CsvSource(value = {"1, 1스트라이크", "2, 2스트라이크", "3, 3스트라이크"})
            void X스트라이크_문자열을_리턴한다(int count, String result) {
                Strike strike = Strike.valueOf(count);
                assertThat(strike.toString()).isEqualTo(result);
            }
        }
    }
}
