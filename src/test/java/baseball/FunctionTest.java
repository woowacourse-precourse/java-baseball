package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @DisplayName("컴퓨터 랜덤 번호의 각 자리의 범위를 검사")
    @Test
    void RandomNumberRangeTest() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> comNumber = computerRandomNumber.makeComputerNumber();

        for (int i = 0; i < comNumber.size(); i++) {
            assertThat(comNumber.get(i)).isGreaterThan(0).isLessThan(10);
        }
    }
}