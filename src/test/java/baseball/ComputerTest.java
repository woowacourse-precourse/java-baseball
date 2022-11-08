package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Computer computer;
    static final int MAX_SIZE = 3;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    @DisplayName("랜덤으로 뽑은 숫자 길이 확인하는 테스트")
    void testWithComputerSourceLength() {
        assertThat(computer.getNumbers().size())
                .as("숫자 길이가 3이 아닙니다.")
                .isEqualTo(MAX_SIZE);
    }
}
