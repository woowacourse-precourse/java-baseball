package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void answer() {

        List<Integer> answer = List.of(0, 3);
        assertTrue(Answer.checkAnswer(answer));

    }

    @Test
    void notAnswer() {

        List<Integer> answer = List.of(1, 2);
        assertFalse(Answer.checkAnswer(answer));

    }
}