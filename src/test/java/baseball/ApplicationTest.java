package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.Application.getStringQuizNumber;
import static baseball.Application.isNotEqualNumber;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 컴퓨터의_퀴즈_숫자가_3자리가_맞는지_확인() {
        assertThat(getStringQuizNumber().length()).isEqualTo(3);
    }

    @Test
    void 컴퓨터의_퀴즈_숫자가_1부터_9까지가_맞는지_확인() {
        int testNum = 10;
        for (int i = 0; i < testNum; i++) {
            String quizNumber = getStringQuizNumber();
            for (int j = 0; j < quizNumber.length(); j++) {
                int quizNumChar = quizNumber.charAt(j) - '0';
                assertThat(1 <= quizNumChar && quizNumChar <= 9).isEqualTo(true);
            }
        }
    }

    @Test
    void 예외_테스트_추가_입력_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12345"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱㄴㄷ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("131"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatNoException().isThrownBy(() -> runException("123"))
        );
    }

    @Test
    void 유저입력과_컴퓨터_숫자를_비교_확인() {
        assertSimpleTest(() -> {
            isNotEqualNumber("123", "713");
            isNotEqualNumber("145", "713");
            isNotEqualNumber("671", "713");
            isNotEqualNumber("216", "713");
            isNotEqualNumber("713", "713");

            assertThat(output().split("\r\n"))
                    .containsExactly(
                    "1볼 1스트라이크",
                    "1볼",
                    "2볼",
                    "1스트라이크",
                    "3스트라이크",
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                    );
        });
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
