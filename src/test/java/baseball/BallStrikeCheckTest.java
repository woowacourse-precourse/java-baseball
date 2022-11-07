package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallStrikeCheckTest {
    BallStrikeCheck ballstrike = new BallStrikeCheck();

    @Test
    void ballStrikeTest1() {
        List<String> computerNumber = List.of("4", "8", "6");
        String userNumber = "476";
        int result = 1;
        assertThat(ballstrike.ballStrikePrintSet(computerNumber, userNumber) == result);
    }

    @Test
    void ballStrikeTest2() {
        List<String> computerNumber = List.of("4", "8", "6");
        String userNumber = "486";
        int result = 2;
        assertThat(ballstrike.ballStrikePrintSet(computerNumber, userNumber) == result);
    }

    @Test
    void ballStrikeTest3() {
        List<String> computerNumber = List.of("4", "8", "6");
        String userNumber = "123";
        int result = 0;
        assertThat(ballstrike.ballStrikePrintSet(computerNumber, userNumber) == result);
    }
}
