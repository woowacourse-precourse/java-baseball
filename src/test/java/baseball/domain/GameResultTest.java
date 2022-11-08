package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    Player player;
    Computer computer;
    GameResult gameResult = new GameResult();

    @DisplayName("calculate 메서드는 게임 결과를 반환한다")
    @Test
    void calculateGameResult() {
        computer = new Computer(List.of(4, 5, 6));

        player = new Player(List.of(1, 2, 3));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("낫싱");

        player = new Player(List.of(2, 4, 6));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("1볼 1스트라이크");

        player = new Player(List.of(2, 5, 4));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("1볼 1스트라이크");

        player = new Player(List.of(1, 5, 6));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("2스트라이크");

        player = new Player(List.of(6, 4, 5));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("3볼");

        player = new Player(List.of(4, 5, 6));
        gameResult.calculate(computer, player);
        assertThat(gameResult.toString()).contains("3스트라이크");
    }
}
