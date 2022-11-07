package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

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
    void 세개의_난수_생성() {
        NumberGenerator generator = new NumberGenerator();
        generator.generateNumber();

        assertSame(3, generator.getNumbers().size());

        // 1부터 9사이의 숫자인 지와 빈도 수를 통해 중복되는 값이 있는 지를 확인
        for(int number : generator.getNumbers()) {
            assertTrue(1 <= number && number <= 9);
            assertSame(1, Collections.frequency(generator.getNumbers(), number));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
