package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballNumbersFactory 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumbersFactoryTest {
    private BaseballNumbersFactory sut = new BaseballNumbersFactory();

    @Nested
    class generate_메서드는 {

        @Nested
        class 만약_입력된_값이_없는_경우 {

            @Test
            void 무작위로_생성된_값을_가지고_BaseballNumbers를_생성하여_반환한다() {
                BaseballNumbers baseballNumbers = sut.generate();

                assertThat(baseballNumbers).isInstanceOf(BaseballNumbers.class);
            }
        }

        @Nested
        class 만약_중복되지_않은_3개의_숫자가_있는_문자열이_입력된_경우 {
            private final String givenString = "841";

            @Test
            void 입력된_값을_가지고_BaseballNumbers를_생성하여_반환한다() {
                BaseballNumbers baseballNumbers = sut.generate(givenString);

                assertThat(baseballNumbers).isInstanceOf(BaseballNumbers.class);
            }
        }

        @Nested
        class 만약_허용되지_않은_문자열이_입력된_경우 {
            private final String givenString = "배고파300";

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> sut.generate(givenString))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }
}
