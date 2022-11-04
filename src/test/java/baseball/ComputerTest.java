package baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    List<Integer> getPrivateAccessToComputerAnswer(Computer computer) {
        List<Integer> computerAnswer = new ArrayList<Integer>();
        try {
            Field privateField = computer.getClass().getDeclaredField("computerAnswer");
            privateField.setAccessible(true);
            return (List<Integer>) privateField.get(computer);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return computerAnswer;
    }

    @Test
    void sizeOfAnswerShouldBeThree() {
        Computer computer = new Computer();
        List<Integer> computerAnswer = getPrivateAccessToComputerAnswer(computer);

        assertEquals(3, computerAnswer.size());
    }

    @Test
    void digitsShouldBeInRangeOneToNine() {
        Computer computer = new Computer();
        List<Integer> computerAnswer = getPrivateAccessToComputerAnswer(computer);
        Boolean inRange = true;

        for (Integer digit : computerAnswer){
            if (digit < 1 || digit > 9) {
                inRange = false;
                break;
            }
        }
        assertEquals(true, inRange);
    }

    @Test
    void digitsShouldBeDistinct() {
        Computer computer = new Computer();
        List<Integer> computerAnswer = getPrivateAccessToComputerAnswer(computer);
        Boolean distinct = true;
        HashMap<Integer, String> digitsArray = new HashMap<Integer, String>();

        for (Integer digit : computerAnswer) {
            if (digitsArray.get(digit) != null) {
                distinct = false;
                break;
            }
            digitsArray.put(digit, "checked");
        }
        assertEquals(true, distinct);
    }
}