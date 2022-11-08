package computer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomTest {
    @Test
    void 서로_다른_세자리수_확인(){
        List<Integer> randomNumber = Random.getRandomNumber();
        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(1));
        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(2));
        assertThat(randomNumber.get(1)).isNotEqualTo(randomNumber.get(2));
    }
}
