package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @BeforeEach
    void start() {
        Application.setIsContinue("1");
    }

    @Test
    void 입력값이_유효한지_확인() {
        assertThat(Application.isValid("1234")).isEqualTo(false);
        assertThat(Application.isValid("12a")).isEqualTo(false);
        assertThat(Application.isValid("123")).isEqualTo(true);
    }

    @Test
    void 재시작_선택시_isContinue는_true() {
        assertThat(Application.isContinue).isEqualTo(true);
        Application.setIsContinue("1");
        assertThat(Application.isContinue).isEqualTo(true);
    }

    @Test
    void 종료_선택시_isContinue는_false() {
        assertThat(Application.isContinue).isEqualTo(true);
        Application.setIsContinue("2");
        assertThat(Application.isContinue).isEqualTo(false);
    }

    @Test
    void 점수_체크() {
        Score score = Application.checkAnswer(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(score.getScore()).isEqualTo("3스트라이크");
    }

    @Test
    void 문자열_숫자_리스트로_변경() {
        List<Integer> integerList = Application.stringConvertToIntegerList("123");
        assertThat(integerList).isEqualTo(Arrays.asList(1, 2, 3));
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
