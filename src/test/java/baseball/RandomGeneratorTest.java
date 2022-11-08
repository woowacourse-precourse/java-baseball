package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RandomGeneratorTest {

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
    @Order(1)
    public void RandomGeneratorTest500Times() {

        for (int i = 0; i < 500; i++) {
            RandomGenerator randomGenerator = new RandomGenerator();
            RandomNumber randNum = randomGenerator.generateRandom(new StringBuilder(), new ArrayList<Integer>(),4);
            Assertions.assertThat(randNum.randomNumInChar(0)).isNotEqualTo(randNum.randomNumInChar(1));
            Assertions.assertThat(randNum.randomNumInChar(1)).isNotEqualTo(randNum.randomNumInChar(2));
            Assertions.assertThat(randNum.randomNumInChar(0)).isNotEqualTo(randNum.randomNumInChar(2));
        }
    }
}