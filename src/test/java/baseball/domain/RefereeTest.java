package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest extends NsTest {

    @Test
    @DisplayName("스트라이크 개수 확인")
    void case1() {
        assertThat(3).isEqualTo(
                Referee.getStrikeCount(
                        Arrays.asList(1, 2, 3),
                        "123")
        );
    }

    @Test
    @DisplayName("낫싱 확인")
    void case2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Referee.printResult(list1, "456");
        assertThat(output()).contains("낫싱");
    }

    @Test
    @DisplayName("볼 개수 확인")
    void case3() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Referee.printResult(list1, "351");
        assertThat(output()).contains("2볼");
    }

    @Test
    @DisplayName("볼 + 스트라이크 개수 확인")
    void case4() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Referee.printResult(list1, "132");
        assertThat(output()).contains("2볼 1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
