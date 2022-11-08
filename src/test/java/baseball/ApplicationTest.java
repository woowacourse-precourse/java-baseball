package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쓰리스트라이크_일시_메시지를_출력(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 2, 3
        );
    }

    @Test
    void readline으로_입력시_Scanner와_달리_공백을_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4 1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 볼_인덱스_추가_이후_스트라이크_인덱스_추가_테스트() {
        String[] computer_number_list = {"1", "3", "4"};
        String[] input_number_list = {"1", "2", "3"};
        List<Integer> strike_ball_nothing_list = Arrays.asList(0, 0, 0);
        for (int i = 0; i < input_number_list.length; i++) {
            if (Arrays.asList(computer_number_list).contains(input_number_list[i])) {
                strike_ball_nothing_list.set(i, 1);
            }
        }
        for (int i = 0; i < input_number_list.length; i++) {
            if (input_number_list[i].equals(computer_number_list[i])) {
                strike_ball_nothing_list.set(i, 2);
            }
        }
        assertThat(strike_ball_nothing_list).containsExactly(2, 0, 1);
    }

    @Test
    void 결과_출력시_trim_기능이_제대로_작동하는지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "189", "135", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
