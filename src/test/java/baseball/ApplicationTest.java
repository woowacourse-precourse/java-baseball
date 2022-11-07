package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 랜덤숫자얻기() {
        assertThat(Application.getRandomThreeNumbers()).hasSize(3);
    }

    @Test
    void 정수_정수리스트_변환() {
        assertThat(Application.getUserNumberList(123)).hasSize(3);
    }

    @Test
    void 중복된_숫자가_있는지_판별() {
        assertThat(Application.hasDuplication("123")).isFalse();
    }

    @Test
    void 다른_숫자나_문자가_있는지_판별() {
        assertThat(Application.hasOtherNumbersOrChars("ABC")).isTrue();
        assertThat(Application.hasOtherNumbersOrChars("102")).isTrue();
        assertThat(Application.hasOtherNumbersOrChars("A21")).isTrue();
        assertThat(Application.hasOtherNumbersOrChars("123")).isFalse();
    }

    @Test
    void 입력_예외_테스트() {
        assertThatThrownBy(() -> Application.handleInputException("113"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 입력되었습니다.");
        assertThatThrownBy(() -> Application.handleInputException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리를 초과하는 숫자가 입력되었습니다.");
        assertThatThrownBy(() -> Application.handleInputException("1A3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 범위 이외의 숫자나 문자가 입력되었습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
