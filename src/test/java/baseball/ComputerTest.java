package baseball;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// class @Nest
@SuppressWarnings("unchecked")
class ComputerTest {
    List<String> getPrivateAccessToComputerAnswer(Computer computer) {
        List<String> computerAnswer = new ArrayList<>();
        try {
            Field privateField = computer.getClass().getDeclaredField("computerAnswer");
            privateField.setAccessible(true);

            return (List<String>) privateField.get(computer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return computerAnswer;
    }

    @Test
    void sizeOfAnswerShouldBeThree() {
        Computer computer = new Computer();
        List<String> computerAnswer = getPrivateAccessToComputerAnswer(computer);

        assertEquals(3, computerAnswer.size());
    }

    @Test
    void digitsShouldBeInRangeOneToNine() {
        Computer computer = new Computer();
        List<String> computerAnswer = getPrivateAccessToComputerAnswer(computer);
        Boolean inRange = true;

        for (String stringDigit : computerAnswer){
            Integer digit = Integer.parseInt(stringDigit);
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
        List<String> computerAnswer = getPrivateAccessToComputerAnswer(computer);
        Boolean distinct = true;
        HashMap<String, String> digitsMap = new HashMap<>();

        for (String digit : computerAnswer) {
            if (digitsMap.get(digit) != null) {
                distinct = false;
                break;
            }
            digitsMap.put(digit, "checked");
        }
        assertEquals(true, distinct);
    }

    @Test
    void giveHintTest() {
        Computer computer = new Computer();
        List<String> computerAnswer = getPrivateAccessToComputerAnswer(computer);

        List<String> playerAnswer = new ArrayList<>();
        List<String> hint = new ArrayList<>();

        playerAnswer.add(computerAnswer.get(2));
        playerAnswer.add(computerAnswer.get(1));
        playerAnswer.add(computerAnswer.get(0));
        hint.add("2");
        hint.add("1");

        List<String> expected = computer.giveHint(playerAnswer);
        assertEquals(expected, hint);
    }
}