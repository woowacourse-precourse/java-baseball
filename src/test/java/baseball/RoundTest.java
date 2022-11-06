package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    private static Computer computer;
    private static int computerNumbers;
    private static int computerNumber1;
    private static int computerNumber2;
    private static int computerNumber3;

    private static Round round;

    @BeforeAll
    static void beforeAll() {
        computer = Computer.getComputer();
        computer.pickNewRandomNumbers();
        computerNumbers = 0;
        computerNumber1 = computer.findComputerNumber(0).getNumber();
        computerNumbers += computerNumber1 * ((int) Math.pow(10, 2));
        computerNumber2 = computer.findComputerNumber(1).getNumber();
        computerNumbers += computerNumber1 * ((int) Math.pow(10, 1));
        computerNumber3 = computer.findComputerNumber(2).getNumber();
        computerNumbers += computerNumber1 * ((int) Math.pow(10, 0));
        System.out.println("computerNumbers = " + computerNumbers);
    }

    @BeforeEach
    void beforeEach() {
        round = Round.getRound();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void roundInputTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        round.startNewRound(computer);

        Field field = Round.class.getDeclaredField("numbers");
        field.setAccessible(true);
        Object numbers = field.get(round);

        System.out.println("computerNumbers = " + computerNumbers);
        assertThat(numbers)
                .isNotNull()
                .isInstanceOf(Numbers.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234"})
    void roundInputExceptionTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> round.startNewRound(computer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("strikeValue")
    void roundStrikeTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        round.startNewRound(computer);
        System.out.println("3Strike input = " + input);
        Field field = Round.class.getDeclaredField("hints");
        field.setAccessible(true);
        Hints hints = (Hints) field.get(round);

        assertThat(hints.findHintCount(Hint.STRIKE))
                .isEqualTo(3);
    }

    private static Stream<Arguments> strikeValue() {
        String input = computerNumbers + "";
        return Stream.of(
                Arguments.of(input, true)
        );
    }

    @Test
    void roundBallTest() {

    }

    @Test
    void roundNothing() {

    }

}
