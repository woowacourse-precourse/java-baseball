package baseball;

import jdk.jfr.Description;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {
    @Test
    void 컴퓨터는_3자리의_숫자를_생성한다() {
        // given
        int randomNumberSetSize = 3;

        // when
        List<BallNumber> testBallNumberList = ComputerNumber.generateRandomNumberSet();

        // then
        assertThat(randomNumberSetSize).isEqualTo(testBallNumberList.size());
    }

    @Test
    @Description("List를 Set으로 변경했을 때 크기가 변하지 않다면, 중복된 숫자가 없다.")
    void 컴퓨터는_서로_다른_숫자의_집합을_생성한다() {
        // given
        int randomNumberSetSize = 3;
        List<BallNumber> testBallNumberList = ComputerNumber.generateRandomNumberSet();

        // when
        Set<BallNumber> testBallNumberSet = Sets.newHashSet(testBallNumberList);

        // then
        assertThat(randomNumberSetSize).isEqualTo(testBallNumberSet.size());
    }
}
