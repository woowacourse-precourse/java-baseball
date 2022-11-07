package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ComputerService Test")
class ComputerServiceTest {

    @Test
    @DisplayName("ComputerService Test")
    void givenRandomNumbers_whenSetComputerNumbers_thenRandomNumbersAndComputerNumbersAreSizeEqual() {
        ComputerService computerService = new ComputerService();
        computerService.setComputerNumber();
        assertThat(computerService.getComputerNumber().size()).isEqualTo(3);
    }

}