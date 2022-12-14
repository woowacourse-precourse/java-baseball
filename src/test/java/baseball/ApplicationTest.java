package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
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
    void 세자리가_들어왔는지_테스트() {

        String input = "123";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(Application.userNumberIsValid(input)).isEqualTo(list);

    }

    @Test
    void 세자리가_들어왔는지_예외테스트1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "1234";
            assertThat(Application.userNumberIsValid(input));
        });
    }

    @Test
    void 세자리가_들어왔는지_예외테스트2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "12";
            assertThat(Application.userNumberIsValid(input));
        });
    }

    @Test
    void 숫자만_들어왔는지_테스트 () {
        String input = "456";
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        assertThat(Application.userNumberIsValid(input)).isEqualTo(list);
    }

    @Test
    void 숫자만_들어왔는지_예외테스트 () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "12a";
            assertThat(Application.userNumberIsValid(input));
        });
    }


    @Test
    void 세_숫자가_다_다른지_테스트 () {
        String input = "789";
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(9);
        assertThat(Application.userNumberIsValid(input)).isEqualTo(list);
    }

    @Test
    void 세_숫자가_다_다른지_예외테스트 () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "112";
            assertThat(Application.userNumberIsValid(input));
        });
    }

    @Test
    void 게임_종료_후_숫자가_1이나_2로_들어오는지_테스트1 () {
        String input = "1";
        assertThat(Application.isGameRetry(input)).isEqualTo(true);
    }

    @Test
    void 게임_종료_후_숫자가_1이나_2로_들어오는지_테스트2 () {
        String input = "2";
        assertThat(Application.isGameRetry(input)).isEqualTo(false);
    }

    @Test
    void 게임_종료_후_숫자가_1이나_2로_들어오는지_예외테스트1 () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "3";
            assertThat(Application.isGameRetry(input));
        });
    }

    @Test
    void 게임_종료_후_숫자가_1이나_2로_들어오는지_예외테스트2 () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String input = "12";
            assertThat(Application.isGameRetry(input));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
