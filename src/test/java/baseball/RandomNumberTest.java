package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RandomNumberTest {

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
    public void RandomNumberTest1() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("156")).isEqualTo(1);
        Assertions.assertThat(randomNumber.countExactSame("156")).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void RandomNumberTest2() {
        RandomNumber randomNumber = new RandomNumber("124");
        Assertions.assertThat(randomNumber.countDuplicate("126")).isEqualTo(2);
        Assertions.assertThat(randomNumber.countExactSame("126")).isEqualTo(2);
    }

    @Test
    @Order(3)
    public void RandomNumberTest3() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("123")).isEqualTo(3);
        Assertions.assertThat(randomNumber.countExactSame("123")).isEqualTo(3);
    }

    @Test
    @Order(4)
    public void RandomNumberTest4() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("417")).isEqualTo(1);
        Assertions.assertThat(randomNumber.countExactSame("417")).isEqualTo(0);
    }

    @Test
    @Order(5)
    public void RandomNumberTest5() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("162")).isEqualTo(2);
        Assertions.assertThat(randomNumber.countExactSame("162")).isEqualTo(1);
    }

    @Test
    @Order(6)
    public void RandomNumberTest6() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("632")).isEqualTo(2);
        Assertions.assertThat(randomNumber.countExactSame("632")).isEqualTo(0);
    }

    @Test
    @Order(7)
    public void RandomNumberTest7() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("132")).isEqualTo(3);
        Assertions.assertThat(randomNumber.countExactSame("132")).isEqualTo(1);
    }

    @Test
    @Order(8)
    public void RandomNumberTest8() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("312")).isEqualTo(3);
        Assertions.assertThat(randomNumber.countExactSame("312")).isEqualTo(0);
    }

    @Test
    @Order(9)
    public void RandomNumberTest9() {
        RandomNumber randomNumber = new RandomNumber("123");
        Assertions.assertThat(randomNumber.countDuplicate("456")).isEqualTo(0);
        Assertions.assertThat(randomNumber.countExactSame("456")).isEqualTo(0);
    }
}