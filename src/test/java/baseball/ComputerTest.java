package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 난수_생성_확인() {
        Computer computer = new Computer();

        computer.generateRandomNumber();

        assertThat(computer.getNumber()).isNotNull();
    }

    @Test
    void 난수가_세_자리_인지_확인() {
        Computer computer = new Computer();

        computer.generateRandomNumber();

        assertThat(computer.getNumber()).hasSize(3);
    }

    @Test
    void 세_자리의_난수가_모두_서로_다른_숫자_인지_확인() {
        Computer computer = new Computer();

        computer.generateRandomNumber();

        assertThat(new HashSet<>(computer.getNumber()).size()).isEqualTo(computer.getNumber().size());
    }
}