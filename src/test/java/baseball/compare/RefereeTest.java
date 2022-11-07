package baseball.compare;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void judge_메소드는_상대_숫자_리스트_중_같은_인덱스_같은_값이면_STRIKE를_반환() {
        Integer userNumber = 4;
        Integer index = 0;
        List<Integer> opponentNumbers = List.of(4, 2, 5);
        assertThat(Referee.judge(userNumber, index, opponentNumbers))
                .isEqualTo(Optional.of(ComparisonResultType.STRIKE));
    }

    @Test
    void judge_메소드는_상대_숫자_리스트에_값이_포함되면_BALL을_반환() {
        Integer userNumber = 4;
        Integer index = 2;
        List<Integer> opponentNumbers = List.of(4, 2, 5);
        assertThat(Referee.judge(userNumber, index, opponentNumbers)).isEqualTo(Optional.of(ComparisonResultType.BALL));
    }

    @Test
    void judge_메소드는_상대_숫자_리스트에_값이_포함되지_않으면_Empty_반환() {
        Integer userNumber = 1;
        Integer index = 0;
        List<Integer> opponentNumbers = List.of(4, 2, 5);
        assertThat(Referee.judge(userNumber, index, opponentNumbers)).isEqualTo(Optional.empty());
    }
}
