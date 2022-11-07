package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


class ApplicationTest extends NsTest {
    public static final int TARGET_LENGTH = Application.TARGET_LENGTH;
    public static final int MIN_INT = Application.MIN_INT;
    public static final int MAX_INT = Application.MAX_INT;

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
    void createTargetNumber_정상_생성_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertThat(result).contains(2, 4, 7);
                    assertThat(result).containsExactly(4, 7, 2);
                },
                4, 7, 2
        );
    }

    @Test
    void createTargetNumber_정상_생성_확인_중복_제거() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertThat(result).contains(1, 3, 8);
                    assertThat(result).containsExactly(3, 1, 8);
                },
                3, 1, 3, 1, 1, 1, 3, 1, 3, 1, 1, 1, 8
        );
    }

    @RepeatedTest(50)
    void createTargetNumber_생성_결과_유효성_확인() {
        assertSimpleTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertAll(
                            () -> assertThat(result.size()).isEqualTo(3),
                            () -> assertThat(new HashSet<>(result).size()).isEqualTo(TARGET_LENGTH),
                            () -> {
                                for (int num : result) {
                                    assertThat(num).isBetween(MIN_INT, MAX_INT);
                                }
                            }
                    );
                }
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
