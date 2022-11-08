package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RefereeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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
    @Order(2)
    void ReferenceTestDoesNotReturnNull() {
        RandomNumber randomnumber = RandomGenerator.generateRandom(new StringBuilder(), new ArrayList<Integer>(),3);
        //Referee.testReferee("126", randomnumber);
        Assertions.assertThat(Referee.testReferee("126", randomnumber)).isNotEqualTo("");
    }

    @Test
    @Order(3)
    void ReferenceTestDoesNotReturnSomethingElse100Times() {
        for (int i = 0; i < 100; i++) {
            RandomNumber randomnumber = RandomGenerator.generateRandom(new StringBuilder(), new ArrayList<Integer>(),3);
            String output = Referee.testReferee("126", randomnumber);
            ArrayList<String> lineUps = new ArrayList<>(
                Arrays.asList("낫싱", "1볼", "2볼", "3볼", "1볼 1스트라이크", "2볼 1스트라이크", "1스트라이크", "2스트라이크", "3스트라이크"));
            Assertions.assertThat(lineUps.contains(output)).isNotEqualTo(false);
        }
    }
}