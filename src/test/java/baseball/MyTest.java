package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.*;

public class MyTest {

    @Test
    void inputValidationOfUserTest() {
        String input1 = "347";
        String input2 = "393"; //throw IllegalArgumentException
        String input3 = "2347"; //throw IllegalArgumentException
        String input4 = "25"; //throw IllegalArgumentException
        String input5 = "dx5"; //throw IllegalArgumentException

        assertThatCode(() -> inputValidationOfUser(input1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> inputValidationOfUser(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfUser(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfUser(input4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfUser(input5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputValidationOfStartEndConditionTest() {
        String input1 = "1";
        String input2 = "2";
        String input3 = "d"; //throw IllegalArgumentException
        String input4 = "3"; //throw IllegalArgumentException
        String input5 = ""; //throw IllegalArgumentException
        String input6 = "12"; ////throw IllegalArgumentException

        assertThatCode(() -> inputValidationOfStartEndCondition(input1)).doesNotThrowAnyException();
        assertThatCode(() -> inputValidationOfStartEndCondition(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> inputValidationOfStartEndCondition(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfStartEndCondition(input4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfStartEndCondition(input5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidationOfStartEndCondition(input6)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void computerTest() {
        List<Integer> randomThreeDigitNumber = createRandomThreeDigitNumber();
        StringBuilder stringBuilder = new StringBuilder();
        randomThreeDigitNumber.stream().map(String::valueOf).forEach(stringBuilder::append);
        String stringComputer = stringBuilder.toString();

        assertThatCode(() -> inputValidationOfUser(stringComputer)).doesNotThrowAnyException();
    }

    @Test
    void strikeAndBallCounterTest() {
        //Case 1 : Expected = {3(strike), 0(ball)}
        List<Integer> computer1 = userInputToList("123");
        List<Integer> user1 = userInputToList("123");

        List<Integer> strikeAndBallCounter1 = strikeAndBallCounter(computer1, user1);
        int strikes1 = strikeAndBallCounter1.get(0);
        int balls1 = strikeAndBallCounter1.get(1);

        assertThat(strikes1).isEqualTo(3);
        assertThat(balls1).isEqualTo(0);

        //Case 2 : Expected = {1(strike), 2(ball)}
        List<Integer> computer2 = userInputToList("341");
        List<Integer> user2 = userInputToList("314");

        List<Integer> strikeAndBallCounter2 = strikeAndBallCounter(computer2, user2);
        int strikes2 = strikeAndBallCounter2.get(0);
        int balls2 = strikeAndBallCounter2.get(1);

        assertThat(strikes2).isEqualTo(1);
        assertThat(balls2).isEqualTo(2);

        //Case 3 : Expected = {0(strike), 3(ball)}
        List<Integer> computer3 = userInputToList("972");
        List<Integer> user3 = userInputToList("297");

        List<Integer> strikeAndBallCounter3 = strikeAndBallCounter(computer3, user3);
        int strikes3 = strikeAndBallCounter3.get(0);
        int balls3 = strikeAndBallCounter3.get(1);

        assertThat(strikes3).isEqualTo(0);
        assertThat(balls3).isEqualTo(3);

        //Case 4 : Expected = {0(strike), 0(ball)}
        List<Integer> computer4 = userInputToList("928");
        List<Integer> user4 = userInputToList("314");

        List<Integer> strikeAndBallCounter4 = strikeAndBallCounter(computer4, user4);
        int strikes4 = strikeAndBallCounter4.get(0);
        int balls4 = strikeAndBallCounter4.get(1);

        assertThat(strikes4).isEqualTo(0);
        assertThat(balls4).isEqualTo(0);
    }

    @Test
    void printResultTest() {
        OutputStream out;

        //Case 1
        int strikes1 = 1;
        int balls1 = 0;

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        printResult(strikes1, balls1);

        assertThat("1스트라이크").isEqualTo(out.toString().trim());

        //Case 2
        int strikes2 = 2;
        int balls2 = 1;

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        printResult(strikes2, balls2);

        assertThat("1볼 2스트라이크").isEqualTo(out.toString().trim());

        //Case3
        int strikes3 = 0;
        int balls3 = 0;

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        printResult(strikes3, balls3);

        assertThat("낫싱").isEqualTo(out.toString().trim());
    }
}
