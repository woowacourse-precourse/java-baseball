package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private BaseBallGame baseBallGame = new BaseBallGame();

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

    @Nested
    class RandomNumbersTest {
        @Test
        void 난수_생성시_중복여부_확인() {
            List<Integer> randomNums = baseBallGame.randomNumbers();
            Set<Integer> setRandomNums = new HashSet<>(randomNums);

            assertEquals(randomNums.size(), setRandomNums.size());
        }

        @Test
        void 난수_범위가_1_9_인지() {
            List<Integer> randomNums = baseBallGame.randomNumbers();
            assertThat(randomNums.stream().allMatch(randomNum -> randomNum >= 1 && randomNum <= 9)).isTrue();

        }
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

