package baseball.model;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest extends NsTest {
    private Computer computer = new Computer();

    @Test
    public void 서로다른_3자리의_숫자() {
        computer.generateNumber();
        List<Integer> numberList = computer.getNumberList();
        long distinctNumberCount = numberList
                                    .stream()
                                    .distinct()
                                    .count();

        Assertions.assertEquals(distinctNumberCount, 3);
    }

    @Test
    public void 힌트_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "571", "175", "587", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "1볼 1스트라이크", "2볼", "3스트라이크", "게임 종료");
                },
                5, 8, 7
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}