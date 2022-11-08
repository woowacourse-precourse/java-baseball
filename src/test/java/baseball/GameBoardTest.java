package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {

    GameBoard gameBoard = new GameBoard();

    @Test
    void case1_랜덤값_확인() {
        try {
            Field result = gameBoard.getClass().getDeclaredField("randomNumbers");
            result.setAccessible(true);
            assertThat(gameBoard.createRandomNumbers())
                    .isEqualTo(result.get(gameBoard));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
