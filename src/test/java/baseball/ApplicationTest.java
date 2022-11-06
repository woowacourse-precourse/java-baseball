package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    //입력값 입력.
                    //run => 인자값들을 입력값으로 바꾸고 Application을 실행시킴.
                    //Application의 출력값이 각각 아래와 같다면 테스트가 통과하는 형식...?
                    run("246", "135", "1", "597", "589", "2"); //1:게임 재시작 2:게임 종료
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },

                1, 3, 5, 5, 8, 9  //정답 숫자가 135 -> 589 로 바뀜..
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
    void 중복되지_않은_3개의_숫자() {


    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
