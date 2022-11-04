package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ApplicationMethodTest {

    @Test
    void createComputerLength3IntegerAnswerToList() {
        List<Integer> computerAnswer = Application.createComputerLength3IntegerAnswerToList();
        System.out.println(computerAnswer);

        assertThat(computerAnswer.size()).isEqualTo(3);
        assertThat(computerAnswer.get(0)).isNotSameAs(0);
        assertThat(computerAnswer.get(1)).isNotSameAs(0);
        assertThat(computerAnswer.get(2)).isNotSameAs(0);
    }

    @Test
    void printStartMessage() {
    }

    @Test
    void printGetInputMessage() {
    }

    @Test
    void getUserNumberToInteger() {
    }

    @Test
    void convertIntegerToList() {
    }

    @Test
    void checkIllegalInputForBaseballGame() {
    }
}