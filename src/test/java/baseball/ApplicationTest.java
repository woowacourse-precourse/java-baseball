package baseball;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    void 컴퓨터_수_생성_및_중복_검사() {
        List<Integer> computer = Application.inputComputer();
        for (int item : computer) {
            assertThat(item).isBetween(1,9);
        }
        Set<Integer> numSet = new HashSet<>(computer);
        assertThat(numSet.size()).isEqualTo(computer.size());
    }
    @Test
    void 사용자_입력_리스트_생성() {
        List<Integer> user = new ArrayList<>();
        String test = "123";
        List<Integer> list = List.of(1,2,3);
        assertThat(Application.makeUserList(user, test)).isEqualTo(list);
    }
    @Test
    void 사용자의_수_입력_시_입력이_올바르지_않을_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 컴퓨터_유저_비교_테스트() {
        List<Integer> user = List.of(1,2,3);
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user2 = List.of(1,2,4);
        assertThat(Application.compareComputerAndUser(computer, user)).isFalse();
        assertThat(Application.compareComputerAndUser(computer, user2)).isTrue();
    }
    @Test
    void 볼의_개수_일치() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "135", "2");
                    assertThat(output()).contains("3볼");
                },
                1, 3, 5
        );
    }
    @Test
    void 스트라이크_개수_일치() {
        assertRandomNumberInRangeTest(
                () -> {
                    run( "135", "2");
                    assertThat(output()).contains("3스트라이크");
                },
                1, 3, 5
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
    void 다맞출_경우_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run( "135", "2");
                    assertThat(output()).contains("게임 종료");
                },
                1, 3, 5
        );
    }
    @Test
    void 낫싱_힌트_일치() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }
    @Test
    void 종료오류() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "3");
                    },
                    1, 3, 5, 5, 8, 9
            );
        } catch (IllegalArgumentException e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "12");
                    },
                    1, 3, 5, 5, 8, 9
            );
        } catch (IllegalArgumentException e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
