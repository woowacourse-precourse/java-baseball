import static org.assertj.core.api.Assertions.assertThat;

import baseball.MakeRandomNumber;
import org.junit.jupiter.api.Test;

public class CustumTest {
    @Test
    void 랜덤으로_값_가져오기() {
        MakeRandomNumber computer = new MakeRandomNumber();

        assertThat(computer.getRandomNumber().size()).isEqualTo(3);
    }
}
