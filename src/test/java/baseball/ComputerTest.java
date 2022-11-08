package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer = new Computer();
    List<String> computerAnswer = computer.computerAnswer;

    @Test
    void sizeOfAnswerShouldBeThree() {
        assertEquals(3, computerAnswer.size());
    }

    @Test
    void digitsShouldBeInRangeOneToNine() {
        Boolean inRange = true;

        for (String stringDigit : computerAnswer) {
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
        List<String> answer = new ArrayList<>();
        List<String> hint = new ArrayList<>();

        answer.add(computerAnswer.get(2));
        answer.add(computerAnswer.get(1));
        answer.add(computerAnswer.get(0));
        Answer playerAnswer = new Answer(answer);

        hint.add("2");
        hint.add("1");

        List<String> expected = computer.giveHint(playerAnswer);
        assertEquals(expected, hint);
    }
}