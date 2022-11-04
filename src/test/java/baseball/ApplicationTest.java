package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jfr.Description;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫지가_1과9사이가_아니라면_오류를_던진다() {
        int testNumber = 10;

        assertThatThrownBy(() -> new BallNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 야구공_개수가_3개가_아니라면_오류를_던진다() {
        // given
        List<BallNumber> testBallNumberSet = new ArrayList<>();
        testBallNumberSet.add(new BallNumber(1));
        testBallNumberSet.add(new BallNumber(2));
        testBallNumberSet.add(new BallNumber(3));
        testBallNumberSet.add(new BallNumber(4));

        // when, then
        assertThatThrownBy(() -> new PlayerNumber(testBallNumberSet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 컴퓨터는_3자리의_숫자를_생성한다() {
        // given
        int randomNumberSetSize = 3;

        // when
        List<BallNumber> testBallNumberList = GameNumber.generateRandomNumberSet();

        // then
        assertThat(randomNumberSetSize).isEqualTo(testBallNumberList.size());
    }

    @Test
    @Description("List를 Set으로 변경했을 때 크기가 변화지 않다면, 중복된 숫자가 없다.")
    void 컴퓨터는_서로다른_숫자의_집합을_생성한다() {
        // given
        int randomNumberSetSize = 3;
        List<BallNumber> testBallNumberList = GameNumber.generateRandomNumberSet();

        // when
        Set<BallNumber> testBallNumberSet = Sets.newHashSet(testBallNumberList);

        // then
        assertThat(randomNumberSetSize).isEqualTo(testBallNumberSet.size());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
