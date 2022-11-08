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
    void 입력에_문자가_있으면_오류_발생() {

        String inputString = "14Y";
        String[] inputList = inputString.split("");

        assertThat(Application.isIntegerOrCharacter(inputList)).isEqualTo(true);
    }

    @Test
    void 입력_길이가_3보다길면_오류_발생() {

        String inputString = "1489";
        String[] inputList = inputString.split("");

        assertThat(Application.isInputLength(inputList)).isEqualTo(true);
    }

    @Test
    void 입력에_같은_숫자있으면_오류_발생() {

        String inputString = "447";
        String[] inputList = inputString.split("");

        assertThat(Application.isSameNumbers(inputList)).isEqualTo(true);
    }

    @Test
    void 입력이_0을_포함하면_오류_발생() {

        String inputString = "408";
        String[] inputList = inputString.split("");

        assertThat(Application.isContainZero(inputList)).isEqualTo(true);
    }

    @Test
    void 삼_스트라이크_판단() {
        List<Integer> computer = new ArrayList<>(Arrays.asList(7, 2, 6));
        List<Integer> user = new ArrayList<>(Arrays.asList(7, 2, 6)); // expect true
//        List<Integer> user = new ArrayList<>(Arrays.asList(4, 2, 6)); // expect false

        assertThat(Application.isThreeStrike(computer, user)).isEqualTo(true);
    }

    @Test
    void 스트라이크_볼_개수_판단() {
        List<Integer> computer = new ArrayList<>(Arrays.asList(7, 2, 6));
        List<Integer> oneStrikeOneBallUser = new ArrayList<>(Arrays.asList(7, 6, 3)); // expect [1, 1](1스트라이크 1볼)
        List<Integer> zeroStrikeTwoBallUser = new ArrayList<>(Arrays.asList(6, 7, 1)); // expect [0, 2](0스트라이크 2볼)
        List<Integer> nothingUser = new ArrayList<>(Arrays.asList(9, 3, 4)); // expect [0, 0](낫싱)

        assertThat(Application.checkStrikeCount(computer, oneStrikeOneBallUser)).isEqualTo(Arrays.asList(1, 1));
        assertThat(Application.checkStrikeCount(computer, zeroStrikeTwoBallUser)).isEqualTo(Arrays.asList(0, 2));
        assertThat(Application.checkStrikeCount(computer, nothingUser)).isEqualTo(Arrays.asList(0, 0));
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
}
