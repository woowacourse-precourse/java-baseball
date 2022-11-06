package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGameResult 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameResultTest {

    @Nested
    class toEnum_메서드는 {

        @Nested
        class 만약_Enum_범위_내_존재하는_숫자를_입력받으면 {
            private final int givenStrike = 1;
            private final int givenBall = 0;

            @Test
            void 적절한_BaseballGameResult를_리턴한다() {
                BaseballGameResult baseballGameResult = BaseballGameResult.toEnum(givenStrike, givenBall);
                assertThat(baseballGameResult).isInstanceOf(BaseballGameResult.class);
            }
        }

        @Nested
        class 만약_Enum_범위_내_존재하지_않는_숫자를_입력받으면 {
            private final int givenStrike = 0;
            private final int givenBall = 3;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> BaseballGameResult.toEnum(givenStrike, givenBall))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }
}
