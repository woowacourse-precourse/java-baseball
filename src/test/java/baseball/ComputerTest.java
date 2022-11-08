package baseball;

import baseball.controller.ComputerController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {
    ComputerController computerController = new ComputerController();

    @Test
    void 사용자_컴퓨터_숫자_비교_3스트라이크() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        String hintMessage = "3스트라이크";

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 사용자_컴퓨터_숫자_비교_3볼() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(2, 3, 1);
        String hintMessage = "3볼";

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 사용자_컴퓨터_숫자_비교_1볼_1스트라이크() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(2, 8, 3);
        String hintMessage = "1볼 1스트라이크";

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 사용자_컴퓨터_숫자_비교_낫싱() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(4, 5, 6);
        String hintMessage = "낫싱";

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 사용자_컴퓨터_숫자_비교_3스트라이크_판단() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(computerController.isThreeStrike()).isTrue();
    }

    @Test
    void 사용자_컴퓨터_숫자_비교_3스트라이크_아님_판단() {
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(4, 2, 3);

        computerController.compareNumbers(playerNumbers, computerNumbers);
        assertThat(computerController.isThreeStrike()).isFalse();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
