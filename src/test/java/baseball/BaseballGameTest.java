package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();
    @Test
    void computerNumber() {
        assertThat(baseballGame.createComputerNumber()).isNotEmpty();
        assertThat(baseballGame.createComputerNumber()).doesNotContain(0);
    }

    @Test
    void isValidNumberTest() {
        List<String> testNumber = List.of("012","102","120","1234","111","123","abc","972");
        List<Boolean> result = List.of(false,false,false,false,false,true,false,true);
        for(int index = 0; index<testNumber.size(); index++) {
            assertThat(baseballGame.isValidNumber(testNumber.get(index))).isEqualTo(result.get(index));
        }
    }
}
