package baseball;

import baseball.model.StrikeBall;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Counter;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeBallTest extends NsTest{


    @Test
    void 볼의_개수_계산_테스트_0볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(4,5,6);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int ballCount = strikeBall.getBallCount();

        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void 볼의_개수_계산_테스트_1볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,5,6);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int ballCount = strikeBall.getBallCount();

        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void 볼의_개수_계산_테스트_2볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,5,2);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int ballCount = strikeBall.getBallCount();

        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void 볼의_개수_계산_테스트_3볼(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,1,2);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int ballCount = strikeBall.getBallCount();

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void 스트라이크_개수_계산_테스트_0스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(3,1,2);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int strikeCount = strikeBall.getStrikeCount();

        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 스트라이크_개수_계산_테스트_1스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,5,2);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int strikeCount = strikeBall.getStrikeCount();

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_계산_테스트_2스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,2,5);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int strikeCount = strikeBall.getStrikeCount();

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void 스트라이크_개수_계산_테스트_3스트라이크(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,2,3);

        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        strikeBall.countStrike();
        int strikeCount = strikeBall.getStrikeCount();

        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 스트라이크_개수_계산시_볼_개수_업데이트(){
        List<Integer> input = List.of(1,2,3);
        List<Integer> answer = List.of(1,5,2);


        StrikeBall strikeBall = new StrikeBall(input, answer);
        strikeBall.countBall();
        int ballCount1 = strikeBall.getBallCount();

        strikeBall.countStrike();
        int ballCount2 = strikeBall.getBallCount();
        int strikeCount = strikeBall.getStrikeCount();

        assertThat(ballCount1).isEqualTo(2);

        assertThat(ballCount2).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
