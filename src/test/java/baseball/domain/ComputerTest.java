package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setComputer() {
        computer = new Computer();
    }

    @Test
    void 랜덤_숫자_생성_테스트() {
        List<Integer> randNumbers = computer.getRandNumbers();

        assertThat(randNumbers).hasSize(3)
                .allMatch(number -> number > 0)
                .allMatch(number -> number < 10);
    }

}
