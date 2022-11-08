package baseball.repository;

import baseball.domain.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("ComputerRepositoryTest")
class ComputerRepositoryTest {

    @Test
    @DisplayName("setComputer&getComputer Test")
    void setComputerTest() {
        ComputerRepository computerRepository = new ComputerRepository();
        computerRepository.setComputer(1,2,3);
        assertThat(computerRepository.getComputer().getFirstNumber()).isEqualTo(1);
        assertThat(computerRepository.getComputer().getSecondNumber()).isEqualTo(2);
        assertThat(computerRepository.getComputer().getThirdNumber()).isEqualTo(3);
    }

}