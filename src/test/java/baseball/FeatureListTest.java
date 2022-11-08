package baseball;

import baseball.model.Nums;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.*;
import static baseball.Judgment.judgment;
import static baseball.Judgment.printJudge;
import static baseball.Random.generateNonDuplicateRandomNumber;
import static baseball.Random.generateRandomNumber;
import static baseball.model.Nums.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class FeatureListTest {

    @Test
    void 이미_만들어진_숫자가_아닌_난수_생성_검증() {
        List<Integer> list = List.of(1, 2);
        assertThat(generateNonDuplicateRandomNumber(list)).isNotIn(1, 2);
    }

    @Test
    void digits개의_중복되지_않은_난수_생성_검증() {
        Set<Integer> s = new HashSet<>(generateRandomNumber(3));

        assertThat(s.size()).isEqualTo(3);
    }



    @Test
    void 사용자_입력_문자열을_Set으로_변환() {
        String s = "654";
        Set<Integer> set = Set.of(6, 5, 4);
        assertThat(inputToSet(s)).isEqualTo(set);
    }

    @Test
    void 입력Set의_사이즈가3인지_확인() {
        Set<Integer> set = Set.of(3, 4, 5);
        assertThat(isValidSetSize(set)).isTrue();
    }

    @Test
    void 사용자_입력에서_숫자가_아닌_문자열_확인() {
        String input = "12a";
        assertThat(isNotNumber(input)).isFalse();
        String input2 = "123";
        assertThat(isNotNumber(input2)).isTrue();
    }

    @Test
    void 사용자_입력값_예외_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Nums("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값_확인() {
        String s = "542";
        Integer[] test = new Integer[]{5, 4, 2};
        try {
            Nums nums = new Nums(s);
            assertThat(nums.inputNums).isEqualTo(test);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void 판정테스트() {
        Integer[] input = new Integer[]{1, 2, 3};
        List<Integer> answer = List.of(1, 3, 5);
        int[] result = new int[]{1, 1};
        assertThat(judgment(input, answer)).isEqualTo(result);
    }

    @Test
    void 판정출력테스트() {
        int[] test = new int[]{1, 1};
        assertThat(printJudge(test)).isEqualTo("1볼 1스트라이크");

        int[] test2 = new int[]{0, 3};
        assertThat(printJudge(test2)).isEqualTo("3스트라이크");

        int[] test3 = new int[]{3, 0};
        assertThat(printJudge(test3)).isEqualTo("3볼");

        int[] test4 = new int[]{0, 0};
        assertThat(printJudge(test4)).isEqualTo("낫싱");
    }


}
