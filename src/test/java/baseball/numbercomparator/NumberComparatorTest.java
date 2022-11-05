package baseball.numbercomparator;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * NumberComparator 클래스와 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
class NumberComparatorTest {

    @Test
    void calculateStrikeTest() {
        // 컴퓨터의 수는 713
        List<Integer> computerList = new ArrayList<>(Arrays.asList(7, 1, 3));

        // 1. 123을 입력한 경우 - 1볼 1스트라이크
        List<Integer> userList = new ArrayList<>(Arrays.asList(1, 2, 3));
        Score score = NumberComparator.calculateStrike(computerList, userList);
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(1);

        // 2. 145를 입력한 경우 - 1볼
        userList = new ArrayList<>(Arrays.asList(1, 4, 5));
        score = NumberComparator.calculateStrike(computerList, userList);
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(1);

        // 3. 671을 입력한 경우 - 2볼
        userList = new ArrayList<>(Arrays.asList(6, 7, 1));
        score = NumberComparator.calculateStrike(computerList, userList);
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(2);

        // 4. 216을 입력한 경우 - 1스트라이크
        userList = new ArrayList<>(Arrays.asList(2, 1, 6));
        score = NumberComparator.calculateStrike(computerList, userList);
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(0);

        // 5. 713을 입력한 경우 - 3스트라이크
        userList = new ArrayList<>(Arrays.asList(7, 1, 3));
        score = NumberComparator.calculateStrike(computerList, userList);
        assertThat(score.getStrike()).isEqualTo(3);
        assertThat(score.getBall()).isEqualTo(0);
    }
}