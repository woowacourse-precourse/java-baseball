package baseball.User.UsertTest;

import baseball.User.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {
    @Test

    @DisplayName("컴퓨터 램덤 숫자 생성")
    void randomTest(){
        Computer computer = new Computer();
        int[] test = computer.RandomComputer();
        assertThat(3).isEqualTo(test.length);
    }
}
