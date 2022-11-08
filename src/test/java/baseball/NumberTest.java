package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberTest {
    private static Number number;
    @BeforeEach
    private void getNumber() {
        number = new Number();
    }

    @Test
    void isValidateComputerNumber() {
        number.setComputerNumbers();
        Assertions.assertTrue(check());
    }
    @Test
    void isValidateUserNumber() {
        number.setUserNumbers("356");
        Assertions.assertTrue(check());
    }
    @Test
    void isValidateLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> number.setUserNumbers("12345"));
    }
    @Test
    void isValidateInteger() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> number.setUserNumbers("021"));
    }
    @Test
    void isDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> number.setUserNumbers("112"));
    }
    @Test
    void isCharacter() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> number.setUserNumbers("abc"));
    }
    private boolean check() {
        return checkDuplicate() && checkLength() && checkValidInteger();
    }
    private boolean checkValidInteger() {
        for (int x : number.getNumbers()) {
            if (x < 1 || x > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLength() {
        return number.getNumbers().length == 3;
    }
    private boolean checkDuplicate() {
        int[] numbers = number.getNumbers();
        Set<Integer> set = convertArrToHashset(numbers);
        return numbers.length == set.size();
    }

    private Set<Integer> convertArrToHashset(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toSet());
    }
}
