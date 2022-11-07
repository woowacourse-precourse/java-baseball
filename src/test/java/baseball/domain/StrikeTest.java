package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Strike 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StrikeTest {
    private final int STRIKE_LOWER_BOUND = 0;
    private final int STRIKE_UPPER_BOUND = 3;

    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_0과_3사이의_값을_입력받으면 {

            @Test
            void Strike_객체를_리턴한다() {
                for (int i = STRIKE_LOWER_BOUND; i < STRIKE_UPPER_BOUND; i++) {
                    assertThat(Strike.valueOf(i)).isInstanceOf(Strike.class);
                }
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
}
