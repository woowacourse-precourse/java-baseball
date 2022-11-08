package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    @DisplayName("컴퓨터 숫자를 모두 맞혔는지 확인")
    public void CheckAllStrike() throws Exception {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        BallCollection player = new BallCollection(playerNumbers);

        // when
        Result result = Result.compare(computer, player);

        // then
        assertThat(result.isAllStrike()).isTrue();
    }

    @Test
    @DisplayName("1스트라이크인 경우")
    public void CheckOneStrike() throws Exception {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(1, 4, 5);
        BallCollection player = new BallCollection(playerNumbers);

        //when
        Result result = Result.compare(computer, player);

        //then
        assertThat(result).isEqualTo(new Result(0, 1));
    }

    @Test
    @DisplayName("1볼인 경우")
    public void CheckOneBall() throws Exception {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(2, 4, 5);
        BallCollection player = new BallCollection(playerNumbers);

        //when
        Result result = Result.compare(computer, player);

        //then
        assertThat(result).isEqualTo(new Result(1, 0));
    }

    @Test
    @DisplayName("1볼 1스트라이크인 경우")
    public void checkOneBallOneStrike() throws Exception {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(1, 4, 2);
        BallCollection player = new BallCollection(playerNumbers);

        //when
        Result result = Result.compare(computer, player);

        //then
        assertThat(result).isEqualTo(new Result(1, 1));
    }

    @Test
    @DisplayName("낫싱인 경우")
    public void checkNothing() throws Exception {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);
        BallCollection player = new BallCollection(playerNumbers);

        //when
        Result result = Result.compare(computer, player);

        //then
        assertThat(result).isEqualTo(new Result(0, 0));
    }
}
