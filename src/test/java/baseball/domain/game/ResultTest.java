package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ResultTest {
    GameHint gameHint;
    Player player;
    Computer computer;
    Result result;

    @BeforeEach
    void init() {
        player = Mockito.mock(Player.class);
        computer = Mockito.mock(Computer.class);
        gameHint = Mockito.mock(GameHint.class);
        result = Result.of(gameHint);
    }

    @Test
    @DisplayName("모두 일치한다면 스트라이크만 반환한다")
    void 일치_테스트() {
        when(gameHint.getStrikeScore()).thenReturn(3);
        when(gameHint.getBallScore()).thenReturn(0);

        Assertions.assertThat(result.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("볼과 스트라이크 둘 다 반환한다")
    void 볼_스트라이크_테스트() {
        when(gameHint.getStrikeScore()).thenReturn(2);
        when(gameHint.getBallScore()).thenReturn(1);

        Assertions.assertThat(result.getResult()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    @DisplayName("볼만 반환한다")
    void 볼_테스트() {
        when(gameHint.getStrikeScore()).thenReturn(0);
        when(gameHint.getBallScore()).thenReturn(2);

        Assertions.assertThat(result.getResult()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("낫싱을 반환한다")
    void 낫싱_테스트() {
        when(gameHint.getStrikeScore()).thenReturn(0);
        when(gameHint.getBallScore()).thenReturn(0);

        Assertions.assertThat(result.getResult()).isEqualTo("낫싱");
    }
}
