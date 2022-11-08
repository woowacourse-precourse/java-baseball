package baseball;

import baseball.service.ComputerService;
import baseball.service.impl.ComputerServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ComputerServiceTest {

    ComputerService computerService = new ComputerServiceImpl();

    @Test
    void 랜덤_숫자_자리수_테스트() {
        List<Integer> computerNumber = computerService.createComputerNumber();

        assertThat(computerNumber.size()).isEqualTo(3);
    }

    @Test
    void 랜덤_숫자_범위_테스트() {
        List<Integer> computerNumber = computerService.createComputerNumber();

        computerNumber
                .forEach(number -> assertThat(number).isBetween(1, 9));
    }
}
