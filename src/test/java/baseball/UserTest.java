package baseball;

import baseball.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void setUserNumbersValidationTest() {
        // Arrange
        User sut = new User();
        List<Integer> newUserNumbers = new ArrayList<>();
        newUserNumbers.add(1);
        newUserNumbers.add(3);
        newUserNumbers.add(5);

        // Act
        sut.setUserNumbers(newUserNumbers);

        // Assert
        Assertions.assertEquals(newUserNumbers, sut.getUserNumbers());
    }

}
