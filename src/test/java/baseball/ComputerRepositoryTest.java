package baseball;

import data.ComputerData;
import org.junit.jupiter.api.Test;
import repository.ComputerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerRepositoryTest{

    @Test
    void 랜덤값이_제대로_저장() {
        ComputerData computerData= new ComputerData();
        ComputerRepository computerRepository=new ComputerRepository(computerData);
        computerRepository.setRandomNum();
        List<Integer> data =  new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        assertThat(computerRepository.getComputerData()).isNotEqualTo(data);
    }
}
