package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(
            IllegalArgumentException.class));
    }

    @Test
    @DisplayName("랜덤함수 개수가 맞게 생성됬는지 테스트")
    void 랜덤함수_테스트() {
        int num = 3;
        List<Integer> randomnum = Application.RandomNum(num);
        assertThat(randomnum.size()).isEqualTo(num);

    }

    @Nested
    class 사용자_입력_검증_테스트 {

        @Test
        void 사용자_입력_검증_길이가다른_예외() {
            assertSimpleTest(
                () -> assertThatThrownBy(() -> Application.confirmUserInput("1233")).isInstanceOf(
                    IllegalArgumentException.class));
        }

        @Test
        void 사용자_입력_검증_서로다른수_예외() {
            assertSimpleTest(
                () -> assertThatThrownBy(() -> Application.confirmUserInput("111")).isInstanceOf(
                    IllegalArgumentException.class));
        }

        @Test
        void 사용자_입력_검증_숫자가아닌수_예외() {
            assertSimpleTest(
                () -> assertThatThrownBy(() -> Application.confirmUserInput("ㅁㅁㅁ")).isInstanceOf(
                    IllegalArgumentException.class));
            assertSimpleTest(
                () -> assertThatThrownBy(() -> Application.confirmUserInput("aaa")).isInstanceOf(
                    IllegalArgumentException.class));
        }


    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
