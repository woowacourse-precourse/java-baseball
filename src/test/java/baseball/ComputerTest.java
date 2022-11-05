package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @DisplayName("난수를 1000번 돌려 1과 9사이 숫자만 나오는지")
    @Test
    void createRandomNumber() {
        for (int i = 0; i < 1000; i++) {
            assertThat(Randoms.pickNumberInRange(1, 9)).isBetween(1, 9);
        }
    }
}