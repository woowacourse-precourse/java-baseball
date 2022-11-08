package baseball.domain.repository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberRepositoryTest {

    NumberRepository numberRepository = new NumberRepositoryImpl();

    @Test
    public void setNumbers(){
        ///given
        List<Integer> originNumbers = Arrays.asList(1,2,3);

        //when
        numberRepository.setNumbers(originNumbers);
        List<Integer> savedNumbers = numberRepository.getNumbers();

        //then
        assertThat(savedNumbers).isEqualTo(originNumbers);
    }
}