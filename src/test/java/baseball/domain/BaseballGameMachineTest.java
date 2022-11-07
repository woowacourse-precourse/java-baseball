package baseball.domain;

import static baseball.domain.BaseballGameResult._2_STRIKE;
import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGameMachine 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameMachineTest {
    private BaseballGameMachine sut;

    private BaseballNumbers generateBaseballNumbers(int ballA, int ballB, int ballC) {
        return new BaseballNumbers(List.of(
                valueOf(ballA),
                valueOf(ballB),
                valueOf(ballC)
        ));
    }

    @BeforeEach
    void setup() {
        sut = new BaseballGameMachine();
    }

    @Nested
    class initialize_메서드는 {

        @Nested
        class Computer의_BaseballNumbers를_입력받고 {
            private BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

            @Test
            void BaseballGameStatus의_상태를_PLAY로_변경한다() {
                sut.initialize(givenNumbers);
                assertThat(sut.isGameContinues()).isTrue();
            }
        }
    }

    @Nested
    class play_메서드는 {
        private BaseballNumbers computer = generateBaseballNumbers(1, 2, 3);

        @Nested
        class 만약_컴퓨터와_동일한_입력값을_받은_경우 {
            private BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

            @Test
            void 게임을_종료하고_게임의_결과를_리턴한다() {
                sut.initialize(computer);
                BaseballGameResult baseballGameResult = sut.play(givenNumbers);

                assertThat(sut.isGameContinues()).isFalse();
                assertThat(baseballGameResult).isEqualTo(_3_STRIKE);
            }
        }

        @Nested
        class 만약_컴퓨터와_다른_입력값을_받은_경우 {
            private BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 4);

            @Test
            void 게임의_결과를_리턴한다() {
                sut.initialize(computer);
                BaseballGameResult baseballGameResult = sut.play(givenNumbers);

                assertThat(sut.isGameContinues()).isTrue();
                assertThat(baseballGameResult).isEqualTo(_2_STRIKE);
            }
        }
    }

    @Nested
    class isGameContinues_메서드는 {
        private BaseballNumbers computer = generateBaseballNumbers(1, 2, 3);

        @Nested
        class 만약_게임을_진행할_수_없는_경우 {
            private BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

            @Test
            void 거짓을_리턴한다() {
                sut.initialize(computer);
                sut.play(givenNumbers);

                assertThat(sut.isGameContinues()).isFalse();
            }
        }

        @Nested
        class 만약_게임을_진행할_수_있는_경우 {
            @Test
            void 참을_리턴한다() {
                sut.initialize(computer);

                assertThat(sut.isGameContinues()).isTrue();
            }
        }
    }
}
