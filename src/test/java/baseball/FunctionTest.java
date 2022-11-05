package baseball;

import baseball.model.ComputerNumber;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @Test
    void ComputerNumber이_중복되지_않은_1에서_9사이의_3자리_숫자인지(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setComputerNumber();
        Set<Integer> checkDuplicate = new HashSet<>(computerNumber.getComputerNumber());

        assertThat(computerNumber.getComputerNumber()
                .size())
                .isEqualTo(3);

        assertThat(checkDuplicate.size())
                .isEqualTo(computerNumber.getComputerNumber().size());

        for(int i = 0; i < 3; i++){

            assertThat(computerNumber.getComputerNumber().get(i))
                    .isBetween(1,9);

        }
    }
}
