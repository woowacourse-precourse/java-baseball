package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GameHintTest {

    GameHint gameHint;
    Player player;
    Computer computer;

    @BeforeEach
    void init() {
        player = Mockito.mock(Player.class);
        computer = Mockito.mock(Computer.class);
    }

    @Test
    @DisplayName("컴퓨터의 수와 일치한 경우 성공으로 판단한다")
    void 일치_테스트() {
        when(computer.getRandomNumbers()).thenReturn(List.of(1, 2, 3));
        when(player.getInputNumbers()).thenReturn(List.of(1, 2, 3));

        gameHint = GameHint.compare(computer, player);

        assertThat(gameHint.getStrikeScore()).isEqualTo(3);
    }

    @Test
    @DisplayName("같은 수가 있지만 다른 자리라면 볼로 판단한다.")
    void 볼_테스트() {
        when(computer.getRandomNumbers()).thenReturn(List.of(1, 2, 3));
        when(player.getInputNumbers()).thenReturn(List.of(3, 1, 2));

        gameHint = GameHint.compare(computer, player);

        assertThat(gameHint.getBallScore()).isEqualTo(3);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있다면 스트라이크로 판단한다.")
    void 스트라이크_테스트() {
        when(computer.getRandomNumbers()).thenReturn(List.of(1, 2, 3));
        when(player.getInputNumbers()).thenReturn(List.of(3, 2, 4));

        gameHint = GameHint.compare(computer, player);

        assertThat(gameHint.getStrikeScore()).isEqualTo(1);
    }
}