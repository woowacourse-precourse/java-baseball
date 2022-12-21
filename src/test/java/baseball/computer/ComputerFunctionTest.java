package baseball.computer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerFunctionTest {
    ComputerFunction com = new ComputerFunction();

    @Test
    void getRandomNumber() {
        int comNum = com.getRandomNumber();
        Assertions.assertThat(1 <= comNum && comNum <= 9)
                .isTrue();
    }

    @Test
    void collectionListCheckValue() {
        int comNum = 1;
        List<Integer> list = List.of(1, 2, 3);
        Assertions.assertThat(list.contains(comNum))
                .isTrue();

    }


}