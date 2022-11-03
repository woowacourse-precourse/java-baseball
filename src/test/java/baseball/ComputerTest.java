package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class ComputerTest {
    Computer computer = new Computer();
    @Test
    void getListFromInt_메서드_테스트() {
        int input = 123;
        List<Integer> result = List.of(1, 2, 3);
        assertThat(computer.getListFromInt(input)).isEqualTo(result);
    }
}
