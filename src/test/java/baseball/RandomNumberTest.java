package baseball;

import baseball.util.RandomNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumberTest {

    @Test
    void generateRandomNumbersTest() {
        // Arrange
        List<Integer> sut;

        // Act
        sut = RandomNumber.getRandomNumbers(1,9, 3);

        // Assert
        Assertions.assertEquals(3, sut.size());
    }

}
