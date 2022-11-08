package study;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void RandomTest(){
        List<Integer> testNum = Application.createRandomNum();
        assertThat(3).isEqualTo(testNum.size());
    }
}
