package baseball.domain;

import static baseball.domain.BaseballGameResult._0_STRIKE_1_BALL;
import static baseball.domain.BaseballGameResult._0_STRIKE_2_BALL;
import static baseball.domain.BaseballGameResult._1_STRIKE;
import static baseball.domain.BaseballGameResult._1_STRIKE_1_BALL;
import static baseball.domain.BaseballGameResult._1_STRIKE_2_BALL;
import static baseball.domain.BaseballGameResult._2_STRIKE;
import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballGameResult._NOTHING;
import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        class 만약_3개의_숫자를_모두_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 3, 1);

            @Test
            void _3_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_3_STRIKE);
            }
        }

        @Nested
        class 만약_추론된_수가_하나도_없는_경우 {

            private BaseballNumbers player = generateBaseballNumbers(2, 4, 7);

            @Test
            void _0_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_NOTHING);
            }
        }

        @Nested
        class 만약_2개의_숫자를_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(4, 3, 1);

            @Test
            void _2_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_2_STRIKE);
            }
        }

        @Nested
        class 만약_상대방이_1개의_숫자를_맞추고_2개는_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 1, 3);

            @Test
            void _1_Strike_2_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_1_STRIKE_2_BALL);
            }
        }

        @Nested
        class 만약_1개의_숫자를_맞추고_1개는_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(9, 5, 3);

            @Test
            void _1_Strike_1_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_1_STRIKE_1_BALL);
            }
        }

        @Nested
        class 만약_1개의_숫자를_맞춘_경우 {

            private BaseballNumbers player = generateBaseballNumbers(4, 8, 1);

            @Test
            void _1_Strike_0_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_1_STRIKE);
            }
        }

        @Nested
        class 만약_맞춘공이_없고_1개가_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(2, 1, 4);

            @Test
            void _0_Strike_1_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_0_STRIKE_1_BALL);
            }
        }

        @Nested
        class 만약_맞춘공이_없고_2개가_위치가_다른_경우 {

            private BaseballNumbers player = generateBaseballNumbers(3, 7, 9);

            @Test
            void _0_Strike_2_Ball의_값을_가진_BaseballGameResult를_반환한다() {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(_0_STRIKE_2_BALL);
            }
        }
    }
}
