package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PlayerTest {

    @Test
    void setPlayerNumber_사용자_입력숫자_변환후_저장() {
        String input = "123";
        Player player = new Player();
        player.setPlayerNumbers(input);
        List<Integer> playerNumbers = player.getPlayerNumbers();
        List<Integer> result = new ArrayList(Arrays.asList(1,2,3));

        Assertions.assertThat(playerNumbers).isEqualTo(result);
    }
}