package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComputerTest {

    @Test
    void testing_컴퓨터_숫자생성(){

        try (final MockedStatic<Randoms> mock=mockStatic(Randoms.class)){
            Computer computer = new Computer();
            mock.when(()->Randoms.pickNumberInRange(anyInt(),anyInt())).thenReturn(1,3,5);
            computer.makeRandomNumber();
            assertThat(computer.isSameNumber(List.of(1,3,5))).isTrue();
        }
    }

    @Test
    void testing_컴퓨터_중복_숫자생성(){

        try (final MockedStatic<Randoms> mock=mockStatic(Randoms.class)){
            Computer computer = new Computer();
            mock.when(()->Randoms.pickNumberInRange(anyInt(),anyInt())).thenReturn(3,5,5,1,3,5);
            computer.makeRandomNumber();
            assertThat(computer.isSameNumber(List.of(1,3,5))).isTrue();
        }
    }

}
