package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerBaseballTest {


    @Test
    @DisplayName("객체 생성시 랜덤한 정수 3개가 들어가있는 리스트가 초기화 되어야함")
    public void ComputerBaseball_init_test() {
        //given
        //when
        ComputerBaseball computerBaseball = new ComputerBaseball();
        List<Integer> baseballNumberList = computerBaseball.getNumberList();
        //then
        assertThat(baseballNumberList.size())
                .isEqualTo(3);
        assertThat(baseballNumberList).allMatch(integer -> integer > 0 && integer < 10);
    }
}
