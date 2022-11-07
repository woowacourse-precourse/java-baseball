package baseball;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Ball;
import baseball.domain.BallFactory;
import baseball.domain.Balls;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallFactoryTest {
    private List<Integer> nums;

    @BeforeEach
    void 공_숫자_생성(){
        nums = Arrays.asList(1,2,3);
    }
    
    @Test
    void 공_생성_테스트(){
        Balls balls = BallFactory.createBalls(nums);
        assertThat(balls)
            .extracting("balls")
            .isEqualTo(Arrays.asList(
                 Ball.of(1,1),
                 Ball.of(2,2),
                 Ball.of(3,3)
            ));
    }
}
