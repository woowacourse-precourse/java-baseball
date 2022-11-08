package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballGameStatus 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameStatusTest {

    @Test
    void getEnum_메서드는_만약_1을_입력_받으면_BaseballGameStatus_PLAY를_리턴한다() {
        final Integer given = 1;

        assertThat(BaseballGameStatus.getEnum(given)).isEqualTo(BaseballGameStatus.PLAY);
    }

    @Test
    void getEnum_메서드는_만약_2를_입력_받으면_BaseballGameStatus_STOP을_리턴한다() {
        final Integer given = 2;

        assertThat(BaseballGameStatus.getEnum(given)).isEqualTo(BaseballGameStatus.STOP);
    }

    @Test
    void getEnum_메서드는_만약_statusCode에_없는_다른값을_입력받으면_BaseballGameException_예외를_던진다() {
        final Integer given = 50;

        assertThatThrownBy(() -> BaseballGameStatus.getEnum(given))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void isGameContinues_메서드는_만약_GameStatus가_PLAY인_경우_참을_리턴한다() {
        final BaseballGameStatus sut = BaseballGameStatus.PLAY;
        assertThat(sut.isGameContinues()).isTrue();
    }

    @Test
    void isGameContinues_메서드는_만약_GameStatus가_STOP인_경우_거짓을_리턴한다() {
        final BaseballGameStatus sut = BaseballGameStatus.STOP;
        assertThat(sut.isGameContinues()).isFalse();
    }
}
