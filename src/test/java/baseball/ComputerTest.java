package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void 테스트_시작_전_초기화_작업() {
        computer = new Computer();

        computer.generateRandomNumber();
    }

    @Test
    void 난수_생성_확인() {
        assertThat(computer.getNumber()).isNotNull();
    }

    @Test
    void 난수가_세_자리_인지_확인() {
        assertThat(computer.getNumber()).hasSize(3);
    }

    @Test
    void 세_자리의_난수가_모두_서로_다른_숫자_인지_확인() {
        assertThat(new HashSet<>(computer.getNumber()).size()).isEqualTo(computer.getNumber().size());
    }
}