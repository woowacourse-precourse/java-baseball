package baseball;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
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
//
//    @Test
//    @Order(1)
//    void ReferenceTestOneStrike() {
//        Referee referee = new Referee();
//
//
//        Referee.testReferee("156", "123");
//        Assertions.assertThat("1스트라이크").isEqualTo(outContent.toString().trim());
//    }

//    @Test
//    @Order(2)
//    void ReferenceTestTwoStrike() {
//        Referee.testReferee("126", "123");
//        Assertions.assertThat("2스트라이크").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(3)
//    void ReferenceTestThreeStrike() {
//        Referee.testReferee("123", "123");
//        Assertions.assertThat("3스트라이크").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(4)
//    void ReferenceTestOneBall() {
//        Referee.testReferee("417", "123");
//        Assertions.assertThat("1볼").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(5)
//    void ReferenceTestOneBallOneStrike() {
//        Referee.testReferee("162", "123");
//        Assertions.assertThat("1볼 1스트라이크").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(6)
//    void ReferenceTestTwoBall() {
//        Referee.testReferee("632", "123");
//        Assertions.assertThat("2볼").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(7)
//    void ReferenceTestTwoBallOneStrike() {
//        Referee.testReferee("132", "123");
//        Assertions.assertThat("2볼 1스트라이크").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(8)
//    void ReferenceTestThreeBall() {
//        Referee.testReferee("312", "123");
//        Assertions.assertThat("3볼").isEqualTo(outContent.toString().trim());
//    }
//
//    @Test
//    @Order(9)
//    void ReferenceTestNothing() {
//        Referee.testReferee("567", "123");
//        Assertions.assertThat("낫싱").isEqualTo(outContent.toString().trim());
//    }
}