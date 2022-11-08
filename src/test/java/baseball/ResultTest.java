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
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        BallCollection computer = new BallCollection(computerNumbers);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        BallCollection player = new BallCollection(playerNumbers);

        Result result = Result.compare(computer, player);

        assertThat(result.isAllStrike()).isTrue();
    }
}
