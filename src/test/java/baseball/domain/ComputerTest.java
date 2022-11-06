package baseball.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {
    @DisplayName("pickRandomNumbers 메서드는 랜덤 번호를 뽑는다")
    void pickRandomNumbers() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("961");
                },
                9, 6, 1
        );
    }

    @Override
    public void runMain() {
        Computer computer = new Computer();
        computer.pickRandomNumbers();
        List<String> computerNumbers = computer.getNumbers()
                .stream().map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join("", computerNumbers));
    }
}
