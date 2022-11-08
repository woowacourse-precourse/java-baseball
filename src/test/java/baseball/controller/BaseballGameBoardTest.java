package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameBoardTest {

    @Test
    @DisplayName("exit 메서드 테스트")
    void testExitMethod() {
        BaseballGameBoard baseballGameBoard = new BaseballGameBoard();
        baseballGameBoard.playTheGame();
    }

}