package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FeatureListTest {

    @Test
    void 이미_만들어진_숫자가_아닌_난수_생성_검증() {
        List<Integer> list = List.of(1, 2);
        assertThat(GenerateNonDuplicateRandomNumber(list)).isNotIn(1, 2);
    }

    @Test
    void digits개의_중복되지_않은_난수_생성_검증() {
        Set<Integer> s = new HashSet<>(GenerateRandomNumber(3));

        assertThat(s.size()).isEqualTo(3);
    }

    @Test
    void 사용자입력의_크기가_3인지_확인() {
        String s = "345";
        assertThat(isValidLength(s.length())).isTrue();
        String s2 = "3454";
        assertThat(isValidLength(s2.length())).isFalse();
    }

    @Test
    void 사용자_입력_문자열을_Set으로_변환() {
        String s = "654";
        Set<Integer> set = Set.of(6, 5, 4);
        assertThat(InputToSet(s)).isEqualTo(set);
    }

    @Test
    void 입력Set의_사이즈가3인지_확인() {
        Set<Integer> set = Set.of(3, 4, 5);
        assertThat(isValidSetSize(set)).isTrue();
    }

    @Test
    void 사용자_입력값_예외_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Nums("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
