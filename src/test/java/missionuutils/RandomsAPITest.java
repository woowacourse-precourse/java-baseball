package missionuutils;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomsAPITest {

    @Test
    void 숫자_3개_뽑기(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        Assertions.assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    void 다른_숫자_3개_뽑기(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        Assertions.assertThat(computer.get(0)).isNotEqualTo(computer.get(1));
        Assertions.assertThat(computer.get(1)).isNotEqualTo(computer.get(2));
        Assertions.assertThat(computer.get(2)).isNotEqualTo(computer.get(0));
    }


}
