package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballFactory 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
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
    }
}
