package study;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {
    @Test
    @DisplayName("동일한 숫자의 개수 확인")
    void count(){
        assertThat(3).isEqualTo(Application.howManySame(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }
}
