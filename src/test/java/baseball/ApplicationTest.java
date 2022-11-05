package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void 입력이_세자리가_아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
        );
    }

    @Test
    void 입력이_1부터_9사이의_숫자가_아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("q12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
        );
    }

    @Test
    void 같은_숫자를_입력한경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("122"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
        );
    }

    @Test
    void 세개의_난수_생성() {
        NumberGenerator generator = new NumberGenerator();
        generator.generateNumber();

        // 세 개의 난수를 생성하였는 지를 확인
        assertSame(3, generator.getNumbers().size());

        // 1부터 9사이의 숫자인 지와 빈도 수를 통해 중복되는 값이 있는 지를 확인
        for(int number : generator.getNumbers()) {
            assertTrue(1 <= number && number <= 9);
            assertSame(1, Collections.frequency(generator.getNumbers(), number));
        }

        // 생성한 난수를 모두 삭제하는 지를 확인
        generator.truncateNumbers();
        assertSame(0, generator.getNumbers().size());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
