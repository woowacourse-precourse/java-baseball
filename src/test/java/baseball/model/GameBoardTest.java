package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameBoardTest {

    GameBoard gameBoard;
    String ONE_BALL = "1볼 ";
    String ONE_STRIKE = "1스트라이크";
    String ONE_BALL_ONE_STRIKE = ONE_BALL + ONE_STRIKE;
    String NOTHING = "낫싱";

    @BeforeEach
    void init() {
        gameBoard = new GameBoard();
    }

    @Test
    void 결과_1볼() {
        gameBoard.ball();
        assertThat(gameBoard.getResult()).isEqualTo(ONE_BALL);
    }

    @Test
    void 결과_1스트라이크() {
        gameBoard.strike();
        assertThat(gameBoard.getResult()).isEqualTo(ONE_STRIKE);
    }

    @Test
    void 결과_1볼_1스트라이크() {
        gameBoard.ball();
        gameBoard.strike();
        assertThat(gameBoard.getResult()).isEqualTo(ONE_BALL_ONE_STRIKE);
    }

    @Test
    void 결과_쓰리아웃() {
        assertThat(gameBoard.getResult()).isEqualTo(NOTHING);
    }
}
