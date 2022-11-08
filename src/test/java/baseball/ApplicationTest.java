package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    
    @Test
    void 숫자2_입력시_게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                4, 5, 6
        );
    }

    @Test
    void 숫자1_입력시_() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "1", "213", "123", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "2볼 1스트라이크", "게임 종료");
                },
                4, 5, 6, 1, 2, 3
        );
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void 중복된_수_(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "4444", "125125134", " "})
    void 범위_오류(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"안녕", "asd2", "vfs"})
    void 수가_아닌_입력(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }
}
