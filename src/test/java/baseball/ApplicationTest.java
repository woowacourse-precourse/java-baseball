package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
    void testComputersPickIsValid(){
        Computer computer = new Computer();
        ArrayList<Integer> picks = new ArrayList<>();

        for (int num: computer.getComputersPick()){
            assertThat(picks).doesNotContain(num);
            picks.add(num);
        }
    }

    @Test
    void testThrowExceptionForInvalidUserInput(){
        String[] invalidCases = {
                "1234",
                "1e34",
                "1e3",
                "112",
        };
        User user = new User();
        for (String invalidCase: invalidCases){
            assertThatThrownBy(() -> user.validateInput(invalidCase))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
