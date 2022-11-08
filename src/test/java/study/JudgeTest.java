package study;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {
    @Test
    @DisplayName("3볼 확인")
    void ballCheck(){
        assertThat("3볼").isEqualTo(Application.judge(Arrays.asList(3,1,2),Arrays.asList(2,3,1)));
    }

    @Test
    @DisplayName("3스트라이크 확인")
    void strikeCheck(){
        assertThat("3스트라이크").isEqualTo(Application.judge(Arrays.asList(4,5,6),Arrays.asList(4,5,6)));
    }

    @Test
    @DisplayName("낫싱확인")
    void nothingCheck(){
        assertThat("낫싱").isEqualTo(Application.judge(Arrays.asList(4,5,6),Arrays.asList(1,2,3)));
    }
}
