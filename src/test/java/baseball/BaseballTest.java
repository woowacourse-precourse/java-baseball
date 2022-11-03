package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BaseballTest {

    @Test
    void 랜덤_숫자_확인() {
        List<Integer> number = Baseball.getRandomNumber();
        Set<Integer> check = new HashSet<>(number);
        assertThat(number.size()).isEqualTo(3);
        assertThat(check.size()).isEqualTo(3);
        System.out.println(number);
    }
}