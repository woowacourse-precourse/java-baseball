package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class MainGameTest {
    Compare compare;
    Refree judge;

    @BeforeEach
    void setUp(){
        compare = new Compare();
        judge = new Refree();
    }

    @Test
    @DisplayName("낫싱 확인")
    void checkNothing(){
        assertThat("낫싱").isEqualTo(judge.judgement(Arrays.asList(1,2,3),Arrays.asList(4,5,6)));
    }

    @Test
    @DisplayName("3스트라이크 확인")
    void checkStrike(){
        assertThat("3스트라이크").isEqualTo(judge.judgement(Arrays.asList(1,2,3),Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("3볼 확인")
    void checkBall(){
        assertThat("3볼").isEqualTo(judge.judgement(Arrays.asList(1,2,3),Arrays.asList(2,3,1)));
    }
}
