package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class GetRandomThreeNumberTest extends NsTest {
    @Test
    void 중복된_수_생성() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("[1, 3, 5]");
                },
                1, 3, 3, 5
        );
    }

    @Override
    protected void runMain() {
        GetRandomThreeNumber getRandomThreeNumber = new GetRandomThreeNumber();
        System.out.println(getRandomThreeNumber.randomThreeNumber());
    }
}