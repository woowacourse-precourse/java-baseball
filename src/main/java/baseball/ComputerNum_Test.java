package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerNum_Test {
    @Test
    @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")

    void randomTest(){
        ComputerNum random_num = new ComputerNum();
        List<Integer> test = random_num.ComputerNumber();
        assertThat(3).isEqualTo(test.size());
    }
}
