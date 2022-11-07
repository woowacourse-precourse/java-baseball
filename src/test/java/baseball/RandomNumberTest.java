package baseball;

import baseball.util.RandomNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberTest {

    @Test
    void generateRandomNumbersTest() {
        // Arrange
        List<Integer> sut;

        // Act
        sut = RandomNumber.getRandomNumbers(1,9, 3);

        // Assert
        assertEquals(
            3L,
            sut.stream()
            .filter(number -> 1 <= number && number <= 9)
            .count()
        );

    }

}
