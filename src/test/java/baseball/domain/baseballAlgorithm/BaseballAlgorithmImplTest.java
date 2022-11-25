package baseball.domain.baseballAlgorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballAlgorithmImplTest {

    @Test
    void checkBaseballResultTest() {
        //given
        BaseballAlgorithm baseballAlgorithm = new BaseballAlgorithmImpl();

        List<Integer> randomNumber = new ArrayList<>();
        randomNumber.add(2);
        randomNumber.add(6);
        randomNumber.add(4);

        String userInput1 = "247";
        String userInput2 = "264";
        String userInput3 = "357";

        //when
        String result1 = baseballAlgorithm.checkBaseballResult(randomNumber, userInput1);
        String result2 = baseballAlgorithm.checkBaseballResult(randomNumber, userInput2);
        String result3 = baseballAlgorithm.checkBaseballResult(randomNumber, userInput3);

        //then
        assertThat(result1).isEqualTo("1볼 1스트라이크");
        assertThat(result2).isEqualTo("3스트라이크");
        assertThat(result3).isEqualTo("낫싱");
    }

}
