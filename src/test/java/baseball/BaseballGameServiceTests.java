package baseball;

import baseball.service.BaseballGameService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class BaseballGameServiceTests {

    @Test
    public void initGameMethodSuccessTest() {
        // Arrange
        BaseballGameService sut = new BaseballGameService();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int start = 1;
        int end = 9;
        int size = 3;

        // Act
        sut.initGame(start, end, size);

        // Assert
        Assertions.assertEquals(size, sut.getSize());
    }

}
