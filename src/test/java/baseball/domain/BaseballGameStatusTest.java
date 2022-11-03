package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGameStatus Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameStatusTest {

    @Nested
    class getEnum_메서드는 {

        @Nested
        class 만약_1을_입력_받으면 {
            private final Integer given = 1;

            @Test
            void BaseballGameStatus_PLAY를_리턴한다() {
                assertThat(BaseballGameStatus.getEnum(given)).isEqualTo(BaseballGameStatus.PLAY);
            }
        }

        @Nested
        class 만약_2를_입력_받으면 {
            private final Integer given = 2;

            @Test
            void BaseballGameStatus_STOP을_리턴한다() {
                assertThat(BaseballGameStatus.getEnum(given)).isEqualTo(BaseballGameStatus.STOP);
            }
        }

        @Nested
        class 만약_statusCode에_없는_다른값을_입력받으면 {
            private final Integer given = 50;

            @Test
            void IllegalArgumentException_예외를_던진다() {
                assertThatThrownBy(() -> BaseballGameStatus.getEnum(given))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    class isGameContinues_메서드는 {

        @Nested
        class 만약_GameStatus가_PLAY인_경우 {
            private final BaseballGameStatus sut = BaseballGameStatus.PLAY;

            @Test
            void 거짓을_리턴한다() {
                assertThat(sut.isGameContinues()).isTrue();
            }
        }

        @Nested
        class 만약_GameStatus가_STOP인_경우 {
            private final BaseballGameStatus sut = BaseballGameStatus.STOP;

            @Test
            void 참을_리턴한다() {
                assertThat(sut.isGameContinues()).isFalse();
            }
        }
    }
}
