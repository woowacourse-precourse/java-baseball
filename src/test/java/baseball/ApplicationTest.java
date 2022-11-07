package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
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
    void 빈_배열_입력() {
        assertThatThrownBy(() -> {
            new NumberValidator().validateIsEmptyNumbers("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numbers cannot be empty.");
    }

    @Test
    void 중복_숫자_입력() {
        assertThatThrownBy(() -> {
            new NumberValidator().validateIsDuplicate("122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The number is duplicated.");
    }

    @Test
    void 숫자가_아닌_값_입력() {
        assertThatThrownBy(() -> {
            new NumberValidator().validateInputRanges("abc");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You must enter a number between 1 and 9.");
    }

    @Test
    void 사용자_숫자_0_입력() {
        assertThatThrownBy(() -> {
            new NumberValidator().validateInputRanges("109");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You must enter a number between 1 and 9.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
