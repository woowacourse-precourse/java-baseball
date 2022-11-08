package baseball.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallGeneratorTest {
    BallGenerator ballGenerator;
    List<String> range;

    @BeforeEach
    void setUp() {
        ballGenerator = BallGenerator.getInstance();
        range = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test
    void 랜덤_공번호_생성() {
        assertTrue(range.contains(ballGenerator.createRandomBall()));
    }

    @Test
    void 컴퓨터_공번호_3자리_확인() {
        assertThat(ballGenerator.makeComputerBalls().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_공번호_중복숫자_판별() {
        List<String> balls = ballGenerator.makeComputerBalls();
        assertThat(new HashSet<>(balls).size()).isEqualTo(balls.size());
    }

    @Test
    void HashSet_유사정렬_확인() {
        Set<String> tmp = new HashSet<>();
        tmp.add("2");
        tmp.add("8");
        tmp.add("1");
        tmp.add("4");
        assertThat(new ArrayList<>(tmp)).isEqualTo(List.of("1", "2", "4", "8"));
    }
}