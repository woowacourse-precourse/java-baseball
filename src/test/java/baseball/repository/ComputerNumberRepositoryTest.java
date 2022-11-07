package baseball.repository;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.validation.Validation;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerNumberRepositoryTest {

    @Test
    void 컴퓨터_숫자_생성_확인() {
        // given
        ComputerNumberRepository computerNumberRepository = new ComputerNumberRepository();
        Validation validation = new Validation();
        List<Integer> numberList = computerNumberRepository.getNumberList();

        // then
        assertThat(validation.isDuplicateList(numberList)).isEqualTo(false);
    }

}