package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {

    //스트라이크 볼 카운팅 및 결과 출력 기능은 ApplicationTest의 게임종료_후_재시작 메소드 참조
    private NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @Test
    void 사용자_0값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 사용자_중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 사용자_세가지_수_중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1e3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터_숫자_갯수_테스트() {
        List<String> computerTest = numberBaseballGame.createRandomNumber();
        assertThat(computerTest.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_중복_테스트() {
        HashSet<String> computerTest = new HashSet<>(numberBaseballGame.createRandomNumber());
        assertThat(computerTest.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_범위_테스트() {
        List<String> computerTest = numberBaseballGame.createRandomNumber();
        Collections.sort(computerTest);
        assertThat(computerTest.get(0)).isNotEqualTo(0);
    }

    @Test
    void 문자_숫자_구별_테스트() {
        boolean str_or_int1 = numberBaseballGame.isNumeric("a");
        boolean str_or_int2 = numberBaseballGame.isNumeric("1");
        assertThat(str_or_int1).isEqualTo(false);
        assertThat(str_or_int2).isEqualTo(true);
    }

    @Test
    void 종료_입력_예외_테스트() {
        assertThatThrownBy(() -> numberBaseballGame.isRepeatGame(3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberBaseballGame.isRepeatGame('a'))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
