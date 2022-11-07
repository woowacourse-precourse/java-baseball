package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void createBaseBall_RandomNumber_NotDuplicatedAndSize3List() {
        List<Integer> baseball = Application.createBaseBall();
        assertThat(baseball.size())
            .isEqualTo(3);
        assertThat(baseball)
            .doesNotHaveDuplicates();
    }

    @Test
    void convertBaseBallByLine_SizeOver4_IllegalArgumentException() {
        String line = "12345";
        assertThatThrownBy(() -> Application.convertBaseBallByLine(line))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertBaseBallByLine_IncludeChar_IllegalArgumentException() {
        String line = "1z2";
        assertThatThrownBy(() -> Application.convertBaseBallByLine(line))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertBaseBallByLine_DuplicateNumber_IllegalArgumentException() {
        String line = "131";
        assertThatThrownBy(() -> Application.convertBaseBallByLine(line))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertBaseBallByLine_Number3_CorrectList() {
        String line = "135";
        assertThat(Application.convertBaseBallByLine(line))
            .hasSize(3)
            .doesNotHaveDuplicates();
    }

    @Test
    void countStrike_Input123Computer123_Strike3() {
        List<Integer> input = new ArrayList<>();
        List<Integer> computer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            input.add(i + 1);
            computer.add(i + 1);
        }
        assertThat(Application.countStrike(input, computer))
            .isEqualTo(3);
    }

    @Test
    void countStrike_Input123Computer456_Strike0() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<Integer> computer = new ArrayList<>();
        computer.add(4);
        computer.add(5);
        computer.add(6);
        assertThat(Application.countStrike(input, computer))
            .isEqualTo(0);
    }

    @Test
    void countBall_Input123Computer231_Ball3() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<Integer> computer = new ArrayList<>();
        computer.add(2);
        computer.add(3);
        computer.add(1);
        assertThat(Application.countBall(input, computer))
            .isEqualTo(3);
    }

    @Test
    void countBall_Input123Computer132_Ball2AndStrike1() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(3);
        computer.add(2);
        assertThat(Application.countBall(input, computer))
            .isEqualTo(2);
    }

    @Test
    void countBall_Input123Computer456_Ball0() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<Integer> computer = new ArrayList<>();
        computer.add(4);
        computer.add(5);
        computer.add(6);
        assertThat(Application.countBall(input, computer))
            .isEqualTo(0);
    }

    @Test
    void main_SelectChars_IllegalArgumentException() {
        assertSimpleTest(() ->
            assertThatThrownBy(
                () -> run("246", "135", "asdf", "597", "589", "2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
