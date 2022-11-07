package baseball;

import baseball.service.BaseballGameService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseballGameServiceTests {

    @Test
    public void initGameMethodSuccessTest() {
        // Arrange
        BaseballGameService sut = new BaseballGameService();

        int start = 1;
        int end = 9;
        int size = 3;

        // Act
        sut.initGame(start, end, size);

        // Assert
        Assertions.assertEquals(size, sut.getSize());
    }

}
