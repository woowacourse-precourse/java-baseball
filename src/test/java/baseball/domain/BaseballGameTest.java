package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        this.baseballGame = new BaseballGame(new Numbers(1, 2, 3));
    }

    @DisplayName("숫자를 비교해 얻은 힌트를 콜렉션에 담아 반환한다.")
    @Test
    void result() {
        assertThat(baseballGame.result(new Numbers(3, 2, 1)))
                .isEqualTo(new Hints(List.of(Hint.BALL, Hint.STRIKE, Hint.BALL)));
    }

    @DisplayName("힌트 콜렉션의 스트라이크 3개면 false를 반환한다.")
    @Test
    void isNotEnd() {
        Assertions.assertAll(
                () -> assertThat(baseballGame.isNotEnd(new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE))))
                        .isFalse(),
                () -> assertThat(baseballGame.isNotEnd(new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.BALL))))
                        .isTrue()
        );
    }

    @DisplayName("게임을 재시작할지 boolean 값을 반환한다.")
    @Test
    void isRestart() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> baseballGame.isRestart(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(baseballGame.isRestart(1)).isTrue(),
                () -> assertThat(baseballGame.isRestart(2)).isFalse(),
                () -> assertThatThrownBy(() -> baseballGame.isRestart(3)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
