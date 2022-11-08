package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void input_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void String_list_변환_테스트() {
        String input = "123";
        BaseBall bb = new BaseBall();
        List<String> result = bb.getList(input);
        assertThat(result).contains("1","2","3");
    }

    @Test
    void Random_사용자값_같은수_같은자리_테스트() {
        String random = "3";
        int index = 0;
        List<String> input = new ArrayList<>();
        input.add("3");
        input.add("6");
        input.add("8");

        BaseBall bb = new BaseBall();
        bb.checkSameNumberOfDigits(random, index, input);

        assertThat(bb.getStrike()).isEqualTo(1);
    }

    @Test
    void result_볼_테스트() {
        String random = "123";
        String input = "267";

        BaseBall bb = new BaseBall();
        bb.checkSameOfRandomAndMy(Arrays.asList(random.split("")), Arrays.asList(input.split("")));
        bb.makeResult();
        assertThat(output()).contains("볼");
    }

    @Test
    void result_스트라이크_테스트() {
        String random = "123";
        String input = "167";

        BaseBall bb = new BaseBall();
        bb.checkSameOfRandomAndMy(Arrays.asList(random.split("")), Arrays.asList(input.split("")));
        bb.makeResult();
        assertThat(output()).contains("스트라이크");
    }

    @Test
    void result_볼_스트라이크_테스트() {
        String random = "123";
        String input = "137";

        BaseBall bb = new BaseBall();
        bb.checkSameOfRandomAndMy(Arrays.asList(random.split("")), Arrays.asList(input.split("")));
        bb.makeResult();
        assertThat(output()).contains("볼", "스트라이크");
    }

    @Test
    void 스트라이크_3개_테스트() {
        // 스트라이크 3개 만들기
        String random = "123";
        String input = "123";

        BaseBall bb = new BaseBall();
        bb.checkSameOfRandomAndMy(Arrays.asList(random.split("")), Arrays.asList(input.split("")));

        assertThat(bb.isStrike3()).isEqualTo(true);
    }

    @Test
    void restart_테스트() {
        BaseBall bb = new BaseBall();
        String restartInput = "1";
        bb.restart(restartInput);
        assertThat(bb.isRestart()).isEqualTo(true);
    }

    @Test
    void restart_end_테스트() {
        BaseBall bb = new BaseBall();
        String restartInput = "2";
        bb.restart(restartInput);
        assertThat(bb.isRestart()).isEqualTo(false);
    }

    @Test
    void restart_input_예외_테스트() {
        BaseBall bb = new BaseBall();
        String input = "3";
        assertThatThrownBy(() -> bb.makeRestartInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
