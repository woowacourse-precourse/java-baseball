package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationMethodTest {

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
        Application.printStartMessage();
    }

    @Test
    void printGetInputMessage() {
        Application.printGetInputMessage();
    }

    @Test
    void getUserNumberToInteger() {}

    @Test
    void convertIntegerToList() {}

    @Test
    void checkIllegalInputForBaseballGame() {}


    @Test
    void checkWhereIsNotStrike() {
        List<Integer> computerAnswer = new ArrayList<>(){
            {add(3); add(4); add(5);}
        };
        List<Integer> userAnswer = new ArrayList<>(){
            {add(3); add(2); add(5);}
        };
        List<Integer> notStrikeZone = Application.checkWhereIsNotStrike(computerAnswer, userAnswer);

        List<Integer> realAnswer = new ArrayList<>(){{add(1);}};
        assertThat(notStrikeZone).isEqualTo(realAnswer);
    }

    @Test
    void countStrike() {
        List<Integer> notStrikeList = new ArrayList<>(){
            {add(0); add(2);}
        };
        int countTrue = Application.countStrike(notStrikeList);
        assertThat(countTrue).isEqualTo(1);
    }

    @Test
    void printEndingMessage() {
        Application.printEndingMessage();
    }

    @Test
    void countBall() {
        List<Integer> computerAnswer = new ArrayList<>(){
            {add(3); add(6); add(5);}
        };
        List<Integer> userAnswer = new ArrayList<>(){
            {add(3); add(4); add(6);}
        };
        List<Integer> notStrikeList = Application.checkWhereIsNotStrike(computerAnswer, userAnswer);

        int countBall = Application.countBall(computerAnswer, userAnswer, notStrikeList);
        assertThat(countBall).isEqualTo(1);
    }

    @Test
    void printUserScore(){
        int countStrike = 1;
        int countBall = 2;
        Application.printUserScore(countStrike, countBall);
    }
}