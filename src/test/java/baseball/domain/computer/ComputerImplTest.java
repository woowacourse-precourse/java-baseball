package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerImplTest {

    @Test
    void generateRandomNumberTest() {
        //given
        ComputerImpl computer = new ComputerImpl();

        //when //then
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumber1 = computer.generateRandomNumber();
            for (int j = 0; j < randomNumber1.size()-1; j++) {
                assertThat(randomNumber1.get(j)).isNotEqualTo(randomNumber1.get(j + 1));
            }
        }
    }
}
