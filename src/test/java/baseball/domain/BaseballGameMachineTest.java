package baseball.domain;

import static baseball.domain.BaseballGameResult._2_STRIKE;
import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameMachineTest {
    private BaseballGameMachine sut;
    BaseballNumbers computer;

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
        computer = generateBaseballNumbers(1, 2, 3);
    }

    @Test
    void initialize_메서드는_Computer의_BaseballNumbers를_입력받고_BaseballGameStatus의_상태를_PLAY로_변경한다() {
        BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

        sut.initialize(givenNumbers);
        assertThat(sut.isGameContinues()).isTrue();
    }

    @Test
    void play_메서드는_만약_컴퓨터와_동일한_입력값을_받은_경우_게임을_종료하고_게임의_결과를_리턴한다() {
        BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

        sut.initialize(computer);
        BaseballGameResult baseballGameResult = sut.play(givenNumbers);

        assertThat(sut.isGameContinues()).isFalse();
        assertThat(baseballGameResult).isEqualTo(_3_STRIKE);
    }

    @Test
    void play_메서드는_만약_컴퓨터와_다른_입력값을_받은_경우_게임의_결과를_리턴한다() {
        BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 4);

        sut.initialize(computer);
        BaseballGameResult baseballGameResult = sut.play(givenNumbers);

        assertThat(sut.isGameContinues()).isTrue();
        assertThat(baseballGameResult).isEqualTo(_2_STRIKE);
    }

    @Test
    void isGameContinues_메서드는_만약_게임을_진행할_수_없는_경우_거짓을_리턴한다() {
        BaseballNumbers givenNumbers = generateBaseballNumbers(1, 2, 3);

        sut.initialize(computer);
        sut.play(givenNumbers);

        assertThat(sut.isGameContinues()).isFalse();
    }

    @Test
    void isGameContinues_메서드는_만약_게임을_진행할_수_없는_경우_참을_리턴한다() {
        sut.initialize(computer);

        assertThat(sut.isGameContinues()).isTrue();
    }
}
