package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeBallTest extends NsTest{


    @Test
    void 볼의_개수_계산_테스트_0볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(4,5,6);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countBall = counter.countBall();

        assertThat(countBall.get("ball")).isEqualTo(0);
    }

    @Test
    void 볼의_개수_계산_테스트_1볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,5,6);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countBall = counter.countBall();

        assertThat(countBall.get("ball")).isEqualTo(1);
    }

    @Test
    void 볼의_개수_계산_테스트_2볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,5,2);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countBall = counter.countBall();

        assertThat(countBall.get("ball")).isEqualTo(2);
    }

    @Test
    void 볼의_개수_계산_테스트_3볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,1,2);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countBall = counter.countBall();

        assertThat(countBall.get("ball")).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
