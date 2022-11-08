package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void make_random_3_Number() {
        Baseball baseball = new Baseball();
        baseball.setNumber();

        // randomNumberList 길이 3인지 확인
        int numberLength = 3;
        assertThat(baseball.getNumber().size()).isEqualTo(numberLength);

        // randomNumber 1~9사이의 숫자 가지는지 확인
        for (Integer number : baseball.getNumber()) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }

        // 같은 값 없는지 확인
        assertThat(baseball.getNumber().get(0)).isNotEqualTo(baseball.getNumber().get(1));
        assertThat(baseball.getNumber().get(0)).isNotEqualTo(baseball.getNumber().get(2));
        assertThat(baseball.getNumber().get(1)).isNotEqualTo(baseball.getNumber().get(2));
    }

    @Test
    void check_user_input() {
        UserInput userInput = new UserInput();
        String input1 = "123";
        String input2 = "1234";
        String input3 = "112";
        String input4 = "a12";

        assertThat(userInput.check_input(input1)).isEqualTo(true);
        assertThat(userInput.check_input(input2)).isEqualTo(false);
        assertThat(userInput.check_input(input3)).isEqualTo(false);
        assertThat(userInput.check_input(input4)).isEqualTo(false);
    }

    @Test
    void check_strike() {
        Result result = new Result();
        List<Integer> baseball = List.of(1,2,3);
        List<Integer> input1 = List.of(1,2,3);
        List<Integer> input2 = List.of(1,2,4);
        List<Integer> input3 = List.of(4,5,3);
        List<Integer> input4 = List.of(4,5,6);

        result.countStrike(baseball, input1);
        assertThat(result.getStrike()).isEqualTo(3);

        result.countStrike(baseball, input2);
        assertThat(result.getStrike()).isEqualTo(2);

        result.countStrike(baseball, input3);
        assertThat(result.getStrike()).isEqualTo(1);

        result.countStrike(baseball, input4);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
