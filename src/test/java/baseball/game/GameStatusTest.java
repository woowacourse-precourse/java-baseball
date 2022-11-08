package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Balls;
import baseball.domain.CompareResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameStatusTest {

    static Balls com;
    static Balls user;
    static CompareResult compareResult;

    @BeforeEach
    void setUp() {
        com = new Balls(List.of(1, 2, 3));
        user = new Balls(List.of(1, 2, 3));
        compareResult = com.compareTo(user);
    }

    @DisplayName("컴퓨터와 유저의 숫자 비교 결과를 받아 게임의 상태를 반환할 수 있어야 한다.")
    @Test
    void setStatus_비교_결과를_받아_게임의_상태_반환() {
        GameStatus gameStatus = new GameStatus();
        gameStatus.setStatus(compareResult);
        assertThat(gameStatus.isGameEnd()).isTrue();
    }

    @DisplayName("게임이 새로 시작하면 게임의 상태를 초기화할 수 있어야 한다.")
    @Test
    void initStatus_게임_상태_초기화() {
        GameStatus gameStatus = new GameStatus();
        gameStatus.setStatus(compareResult);
        assertThat(gameStatus.isGameEnd()).isTrue();

        // After second
        gameStatus.initStatus();
        assertThat(gameStatus.isGameEnd()).isFalse();
    }
}
