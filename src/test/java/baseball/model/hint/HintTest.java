package baseball.model.hint;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.gamenumber.ComputerNumber;
import baseball.model.gamenumber.PlayerNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HintTest {
    Hint hint;
    ComputerNumber computerNumber;
    PlayerNumber playerNumber;

    @BeforeEach
    void beforeEach() {
        hint = new Hint();
        computerNumber = new ComputerNumber();
        playerNumber = new PlayerNumber();
    }

    @Test
    void 볼_확인() {
        // given
        List<Integer> computerNumberList = new ArrayList<>(List.of(1, 2, 3));
        playerNumber = new PlayerNumber("312");
        List<Integer> playerNumberList = playerNumber.getNumberList();

        // when
        hint.calculateBall(computerNumberList, playerNumberList);
        int ball = hint.getBall();

        // then
        assertThat(ball).isEqualTo(3);
    }

    @Test
    void 스트라이크_확인() {
        // given
        List<Integer> computerNumberList = new ArrayList<>(List.of(1, 2, 3));
        playerNumber = new PlayerNumber("931");
        List<Integer> playerNumberList = playerNumber.getNumberList();

        // when
        hint.calculateStrike(computerNumberList, playerNumberList);
        int strike = hint.getStrike();

        // then
        assertThat(strike).isEqualTo(0);
    }
}