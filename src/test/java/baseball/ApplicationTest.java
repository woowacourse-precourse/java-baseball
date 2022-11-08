package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_볼_낫싱_결과_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("689", "451", "421", "742", "427", "2");
                    assertThat(output()).contains("낫싱", "1스트라이크", "2스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                4, 2, 7
        );
    }

    @Test
    void 유저_입력_올바른지_확인_3자리_미만(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.")
        );
    }

    @Test
    void 유저_입력_올바른지_확인_3자리_초과(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.")
        );
    }

    @Test
    void 유저_입력_올바른지_확인_숫자만(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12r"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.")
        );
    }

    @Test
    void 유저_입력_올바른지_확인_중복_있는지(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.")
        );
    }

    @Test
    void 유저_입력_올바른지_확인_0포함(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0을 제외한 서로 다른 세 자리의 숫자를 입력 해주세요.")
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
