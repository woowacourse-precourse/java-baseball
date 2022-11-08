package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NumberTest {
    private static final int MAX_LENGTH = 3;

    public static Number randomNumber = new Number();

    @Test
    void 난수_체크(){
        randomNumber.setRandomNumber();
        assertTrue(checkValidation(randomNumber));
    }

    private boolean checkValidation(Number number) {
        return checkDuplication(number)
                && checkValidRange(number)
                && checkValidLength(number);
    }

    private boolean checkDuplication(Number number) {
        int[] digits = number.getDigits();
        Set<Integer> digitSet = convertArrToSet(digits);
        return digits.length == digitSet.size();
    }

    private Set<Integer> convertArrToSet(int[] digits) {
        return Arrays.stream(digits).boxed().collect(Collectors.toSet());
    }

    private boolean checkValidRange(Number number) {
        for(int digit: number.getDigits()) {
            if(digit < 1 || digit > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidLength(Number number) {
        return number.getDigits().length == MAX_LENGTH;
    }
}

