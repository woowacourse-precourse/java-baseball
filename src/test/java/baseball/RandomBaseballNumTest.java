package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomBaseballNumTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void randomTest(){
        RandomBaseballNum randomBaseballNum = new RandomBaseballNum();
        List<Integer> test = RandomBaseballNum.randomNum();
        assertThat(3).isEqualTo(test.size());
    }
}