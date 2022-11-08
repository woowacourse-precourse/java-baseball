package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserNumbersTest {
    UserNumbers nubmerTest = new UserNumbers();

    @Test
    void userNumbersTest() {

        List<Integer> userNumbers = nubmerTest.userNumbers;
        nubmerTest.userNumbers(783);

        assertTrue(userNumbers.get(0) == 7);
        assertTrue(userNumbers.get(1) == 8);
        assertTrue(userNumbers.get(2) == 3);
    }

}