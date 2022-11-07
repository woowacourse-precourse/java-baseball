package baseball;

import baseball.domain.Computer;
import baseball.util.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTests {

    private Computer sut;

    @BeforeEach
    public void setup() {
        // Arrange
        sut = new Computer(RandomNumber.getRandomNumbers(1,9,3));
    }

    @Test
    public void gameNumberInitializerSuccessTest() {
        // Act
        List<Integer> gameNumbers = sut.getGameNumbers();

        // Assert
        assertEquals(3, gameNumbers.size());
    }

    @Test
    public void increaseStrikeCountValidationTest() {
        // Arrange
        sut.clearCount();

        // Act
        sut.increaseStrikeCount();

        // Assert
        assertEquals(1, sut.getStrikeCount());
    }

    @Test
    public void increaseBallCountValidationTest() {
        // Arrange
        sut.clearCount();

        // Act
        sut.increaseBallCount();

        // Assert
        assertEquals(1, sut.getBallCount());
    }

    @Test
    public void clearCountMethodValidationTest() {
        // Arrange
        sut.increaseStrikeCount();

        // Act
        sut.clearCount();

        // Assert
        assertEquals(0, sut.getStrikeCount());
    }

}
