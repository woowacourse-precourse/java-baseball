package baseball.domain;

import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.dto.BaseballGameResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballNumbers 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumbersTest {

    private BaseballNumbers generateBaseballNumbers(int ballA, int ballB, int ballC) {
        return new BaseballNumbers(List.of(
                valueOf(ballA),
                valueOf(ballB),
                valueOf(ballC)
        ));
    }

    private void assertBaseballGameResult(BaseballGameResult gameResult, Integer strike, Integer ball) {
        assertThat(gameResult.getStrike()).isEqualTo(strike);
        assertThat(gameResult.getBall()).isEqualTo(ball);
    }

    @Nested
    class 생성자는 {

        @Nested
        class 만약_범위를_벗어난_크기의_리스트를_입력_받으면 {
            List<BaseballNumber> givenList = List.of(valueOf(1));

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> new BaseballNumbers(givenList))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_중복된_숫자가_들어간_리스트를_입력_받으면 {

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> generateBaseballNumbers(9, 3, 3))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }

    @Nested
    class play_메서드는 {

        private BaseballNumbers computer = generateBaseballNumbers(9, 3, 1);

        @Nested
        class 만약_상대방이_3개의_숫자를_모두_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 3, 1);

            @Test
            void _3_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 3, 0);
            }
        }

        @Nested
        class 만약_상대방이_추론된_수가_하나도_없는_경우 {

            private BaseballNumbers player = generateBaseballNumbers(2, 4, 7);

            @Test
            void _0_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 0, 0);
            }
        }

        @Nested
        class 만약_상대방이_2개의_숫자를_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(4, 3, 1);

            @Test
            void _2_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 2, 0);
            }
        }

        @Nested
        class 만약_상대방이_1개의_숫자를_맞추고_2개는_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 1, 3);

            @Test
            void _1_Strike_2_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 1, 2);
            }
        }

        @Nested
        class 만약_상대방이_1개의_숫자를_맞추고_1개는_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 5, 3);

            @Test
            void _1_Strike_1_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 1, 1);
            }
        }

        @Nested
        class 만약_상대방이_1개의_숫자를_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(4, 8, 1);

            @Test
            void _1_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertBaseballGameResult(gameResult, 1, 0);
            }
        }
    }
}
