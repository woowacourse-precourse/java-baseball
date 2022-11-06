package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private BaseBallGame baseBallGame = new BaseBallGame();

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
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
        void 난수_범위가_1_9_인지_확인() {
            List<Integer> randomNums = baseBallGame.randomNumbers();
            assertThat(randomNums.stream().allMatch(randomNum -> randomNum >= 1 && randomNum <= 9)).isTrue();

        }
    }

    @Nested
    class inputNumbersTest {
        @Test
        void 숫자가_아닌_경우_에외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputNumbers("aaa");
            });
        }

        @Test
        void 입력값의_길이가_3이_아닌_경우_예외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputNumbers("12345");
            });

            assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputNumbers("12");
            });
        }

        @Test
        void 중복된_숫자가_있을_경우_예외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.inputNumbers("111");
            });
        }
    }

    @Nested
    class findNumberTest {
        @Test
        void find_Number함수_볼_스트라이크_결과_반환() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            List<Integer> strikeAndBall1 = baseBallGame.findNumber(computerNumber, List.of(1, 3, 0));
            assertEquals("1볼 1스트라이크", baseBallGame.numberToString(strikeAndBall1));

            List<Integer> strikeAndBall2 = baseBallGame.findNumber(computerNumber, List.of(1, 4, 5));
            assertEquals("1스트라이크", baseBallGame.numberToString(strikeAndBall2));

            List<Integer> strikeAndBall3 = baseBallGame.findNumber(computerNumber, List.of(4, 5, 1));
            assertEquals("1볼", baseBallGame.numberToString(strikeAndBall3));

        }

        @Test
        void _3스트라이크인_경우_게임_종료_반환() {
            List<Integer> numbers = List.of(1, 2, 3);
            List<Integer> strikeAndBall = baseBallGame.findNumber(numbers, numbers);

            assertEquals("게임 종료", baseBallGame.numberToString(strikeAndBall));
        }
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

