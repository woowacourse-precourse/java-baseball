package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureTest {

    User user;
    Computer comp;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void init() {
        user = new User();
        comp = new Computer();
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void generateNumber_comp() {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        comp.generateNumber();
        List<Integer> generated = comp.getNumbers();

        assertThat(generated).hasSize(3);
        assertThat(nums).containsAll(generated);
    }

    @Test
    void init_comp() {
        comp.init();
        int strike = comp.getStrike();
        int ball = comp.getBall();

        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
    }

    @Test
    void getStrike_comp() {
        int strike = comp.getStrike();
        assertThat(strike).isEqualTo(0);
    }

    @Test
    void getBall_comp() {
        int ball = comp.getBall();
        assertThat(ball).isEqualTo(0);
    }

    @Test
    void count_comp() {
        List<Integer> target = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userInput = new ArrayList<>(Arrays.asList(1, 3, 5));

        comp.setNumbers(target);
        comp.count(userInput);

        assertThat(comp.getStrike()).isEqualTo(1);
        assertThat(comp.getBall()).isEqualTo(1);
    }

    @Test
    void isNothing_comp() {
        assertThat(comp.isNothing()).isEqualTo(true);

        comp.setStrike(1);
        comp.setBall(0);

        assertThat(comp.isNothing()).isEqualTo(false);
    }

    @Test
    void result_낫싱_comp() {
        comp.setStrike(0);
        comp.setBall(0);
        comp.result();
        assertEquals("낫싱\n", outContent.toString());
    }

    @Test
    void result_볼스트라이크_comp() {
        comp.setStrike(1);
        comp.setBall(2);
        comp.result();
        assertEquals("2볼 1스트라이크\n", outContent.toString());
    }

    @Test
    void result_볼_comp() {
        comp.setStrike(0);
        comp.setBall(2);
        comp.result();
        assertEquals("2볼\n", outContent.toString());
    }

    @Test
    void result_스트라이크_comp() {
        comp.setStrike(2);
        comp.setBall(0);
        comp.result();
        assertEquals("2스트라이크\n", outContent.toString());
    }

    @Test
    void isCorrect_comp() {
        comp.setStrike(1);
        assertThat(comp.isCorrect()).isEqualTo(false);

        comp.setStrike(3);
        assertThat(comp.isCorrect()).isEqualTo(true);
    }

    @Test
    void enterNumber_user() {

    }

    @Test
    void checkInvalid_user() {

    }

    @Test
    void isDigitNumber_user() {

    }

    @Test
    void convertStrToList_user() {

    }


}
