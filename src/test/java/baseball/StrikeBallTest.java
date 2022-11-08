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

    @Test
    void 스트라이크_개수_계산_테스트_0스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,1,2);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countStrike = counter.countStrike();

        assertThat(countStrike.get("strike")).isEqualTo(0);
    }

    @Test
    void 스트라이크_개수_계산_테스트_1스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,5,2);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countStrike = counter.countStrike();

        assertThat(countStrike.get("strike")).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_계산_테스트_2스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,2,5);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countStrike = counter.countStrike();

        assertThat(countStrike.get("strike")).isEqualTo(2);
    }

    @Test
    void 스트라이크_개수_계산_테스트_3스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,2,3);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countStrike = counter.countStrike();

        assertThat(countStrike.get("strike")).isEqualTo(3);
    }

    @Test
    void 스트라이크_개수_계산시_볼_개수_업데이트(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,5,2);

        Counter counter = new Counter(input, answer);
        Map<String, Integer> countBall = counter.countBall();
        assertThat(countBall.get("ball")).isEqualTo(2);

        Map<String, Integer> countStrike = counter.countStrike();

        assertThat(countStrike.get("strike")).isEqualTo(1);
        assertThat(countStrike.get("ball")).isEqualTo(1);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
