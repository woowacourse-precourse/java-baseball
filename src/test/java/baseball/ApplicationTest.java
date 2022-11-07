package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void 입력예외_테스트() {
        final Application app = new Application();

        assertThatThrownBy(() -> app.exceptionCheck("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> app.exceptionCheck("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> app.exceptionCheck("012"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> app.exceptionCheck("abc"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 볼_스트라이크_개수세기(){

        final Application app = new Application();
        List <Integer> answer = Arrays.asList(1,3,5);
        List <Integer> firstUser = Arrays.asList(1,2,3);
        List <Integer> secondUser = Arrays.asList(1,3,4);

        assertThat(app.getBallAndStrike(answer,firstUser).equals("1볼 1스트라이크"));
        assertThat(app.getBallAndStrike(answer,secondUser).equals("2스트라이크"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
