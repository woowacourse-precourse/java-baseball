package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BaseballGameTest {

    BaseballGame baseballGame;

    @BeforeEach
    void makeMock(){
        Computer computer = mock(Computer.class);
        Player player = mock(Player.class);
        baseballGame = new BaseballGame(computer, player);
    }

    @Test
    @DisplayName("답을 하나도 못 맞춘 경우 낫싱")
    void 답을_하나도_못_맞춘_경우_낫싱() {
        Numbers answer = new Numbers(List.of(1, 2, 3));
        Numbers guess = new Numbers(List.of(4, 5, 6));

        BallCount ballCount = baseballGame.countBall(answer, guess);
        assertThat(ballCount.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼, 스트라이크 개수 세기")
    void 볼_스트라이크_개수_세기() {
        Numbers answer = new Numbers(List.of(1, 2, 3));
        Numbers guess = new Numbers(List.of(2, 4, 3));

        BallCount ballCount = baseballGame.countBall(answer, guess);
        assertThat(ballCount.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("답을 다 맞춘 경우 3스트라이크")
    void 답을_다_맞춘_경우() {
        Numbers answer = new Numbers(List.of(1, 2, 3));
        Numbers guess = new Numbers(List.of(1, 2, 3));

        BallCount ballCount = baseballGame.countBall(answer, guess);
        assertThat(ballCount.toString()).isEqualTo("3스트라이크");
    }
}
