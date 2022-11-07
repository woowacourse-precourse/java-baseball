package baseball;

import baseball.Model.Referee;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    private Referee referee = new Referee();

    @Test
    void 스트라이크() {
        referee.isStrike(new ArrayList<>(List.of(1,5,9)), List.of(1,5,9));
        Assertions.assertThat(referee.getStrike()).isEqualTo(3);
    }

    @Test
    void 볼() {
        referee.isBall(List.of(1,2,3), List.of(2,3,4));
        Assertions.assertThat(referee.getBall()).isEqualTo(2);
    }

    @Test
    void 게임_재시작_여부_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            referee.isStart("4");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재시작_여부_예외발생2() {
        Assertions.assertThatThrownBy(() -> {
            referee.isStart(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재시작_여부_정상입력() {
        Assertions.assertThat(referee.isStart("2")).isFalse();
        Assertions.assertThat(referee.isStart("1")).isTrue();
    }
}
