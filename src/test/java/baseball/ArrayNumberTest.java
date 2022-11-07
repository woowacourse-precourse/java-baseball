package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayNumberTest {
    private static final int cnt_nbr = 3;
    private static final int min_nbr = 1;
    private static final int max_nbr = 9;

    private static ArrayNumber arraynbr;

    @BeforeEach
    private void createNumber() {
        arraynbr = new ArrayNumber();
    }

    @Test
    void computer_nbr_verify() {
        arraynbr.setRandomNbr();
        assertTrue(checkVaild());
    }

    @Test
    void Right_input() {
        arraynbr.inputAnswer();
        assertTrue(checkVaild());
    }

    @Test
    void str_input() {
        assertThrows( IllegalArgumentException.class,
                () -> arraynbr.inputAnswer()//abc
        );
    }

    @Test
    void not_three() {
        assertThrows( IllegalArgumentException.class,
                () -> arraynbr.inputAnswer()//1234
        );
    }

    @Test
    void not_range() {
        assertThrows( IllegalArgumentException.class,
                () -> arraynbr.inputAnswer()//102
        );
    }

    @Test
    void duplicate_input() {
        assertThrows( IllegalArgumentException.class,
                () -> arraynbr.inputAnswer()//112
        );
    }

    private boolean checkVaild() {
        return checkRange()
                && checkCount()
                && checkDuplicate();
    }

    private boolean checkRange() {
        for(int digit: arraynbr.getDigits()) {
            if(digit < min_nbr || digit > max_nbr) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCount() {
        return cnt_nbr == arraynbr.getDigits().length;
    }

    private boolean checkDuplicate() {
        int[] digits = arraynbr.getDigits();
        Set<Integer> digitSet = convertArrayToSet(digits);
        return digits.length == digitSet.size();
    }

    private Set<Integer> convertArrayToSet(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toSet());
    }
}