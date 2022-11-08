package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.model.Computer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void randomTest(){
        Computer computer = new Computer();
        List<Integer> test = computer.addRandomNumbers();
        assertThat(3).isEqualTo(test.size());
    }
}
