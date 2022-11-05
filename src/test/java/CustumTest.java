import static org.assertj.core.api.Assertions.assertThat;

import baseball.Computer;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CustumTest {
    @Test
    void 랜덤으로_값_가져오기() {
        Computer computer = new Computer();

        List<Integer> computerRandomNumber = computer.getRandomNumber();

        assertThat(computerRandomNumber.size()).isEqualTo(3);

        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(0));
        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(1));
        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(2));
    }
}
