package study;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class CompareTest {
    @Test
    @DisplayName("동일한 숫자의 개수 확인")
    void count(){
        assertThat(3).isEqualTo(Application.howManySame(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("스트라이크 수 확인")
    void countStrike(){
        assertThat(2).isEqualTo(Application.howManyStrike(Arrays.asList(3, 1, 4), Arrays.asList(3, 2, 4)));
    }
}
