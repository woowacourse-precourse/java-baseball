package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerBallGeneratorTest {
    @Test
    @DisplayName("생성된 컴퓨터의 숫자는 중복이 아닌 3개의 수")
    void 컴퓨터의_숫자는_중복x_3개() {
        List<Integer> computerBalls = ComputerBallGenerator.generateComputerBalls();
        assertDoesNotThrow(() -> UserInputValidator.isValidBalls(computerBalls));
    }
}