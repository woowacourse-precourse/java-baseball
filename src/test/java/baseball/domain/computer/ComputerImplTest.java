package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseballAlgorithm.BaseballAlgorithmImpl;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerImplTest {

    @Test
    void generateRandomNumberTest() {
        //given
        ComputerImpl computer = new ComputerImpl(new BaseballAlgorithmImpl());

        //when //then
        for (int i = 0; i < 1000; i++) {
            List<Integer> randomNumber1 = computer.generateRandomNumber();
            assertThat(randomNumber1.get(0)).isNotEqualTo(randomNumber1.get(1));
            assertThat(randomNumber1.get(1)).isNotEqualTo(randomNumber1.get(2));
            assertThat(randomNumber1.get(0)).isNotEqualTo(randomNumber1.get(2));
        }
    }
}
