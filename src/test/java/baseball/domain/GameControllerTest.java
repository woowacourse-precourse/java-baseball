package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    GameController gameController = GameController.getInstance();

    @Test
    void isClear_맞추지못하면_False() {
        gameController.getComputer().initRandomNumbers();
        List<Integer> computersNumbers = gameController.getComputer().getBallCounts();
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < computersNumbers.size(); i++) {
            userNumbers.add(computersNumbers.get(i) + 1);
        }
        assertFalse(gameController.isClear(userNumbers, computersNumbers));
    }
    
    @Test
    void isClear_맞추면_True() {
        gameController.getComputer().initRandomNumbers();
        List<Integer> computersNumbers = gameController.getComputer().getBallCounts();
        List<Integer> userNumbers = computersNumbers;
        assertTrue(gameController.isClear(userNumbers, computersNumbers));
    }
}