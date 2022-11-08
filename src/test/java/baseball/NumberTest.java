package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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
        Assertions.assertTrue(Check());
    }
    @Test
    void isValidateUserNumber() {
        number.setUserNumbers("356");
        Assertions.assertTrue(Check());
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
    private boolean Check() {
        return CheckDuplicate() && CheckLength() && CheckValidInteger();
    }
    private boolean CheckValidInteger() {
        for (int x : number.getNumbers()) {
            if (x < 1 || x > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean CheckLength() {
        return number.getNumbers().length == 3;
    }
    private boolean CheckDuplicate() {
        int[] numbers = number.getNumbers();
        Set<Integer> set = ConvertArrToHashset(numbers);
        return numbers.length == set.size();
    }

    private Set<Integer> ConvertArrToHashset(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toSet());
    }
}
