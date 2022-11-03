package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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
        List<Integer> picks = new ArrayList<>();

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

    @Test
    void testCountBallsAndStrikes() {
        BaseballGame game = new BaseballGame();
        List<Integer>[] computers = new List[] {
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 5, 1),
                Arrays.asList(7, 9, 6),
                Arrays.asList(4, 5, 6),
        };
        List<Integer>[] users = new List[] {
                Arrays.asList(1, 3, 4), // 1b 1s
                Arrays.asList(6, 8, 9), // out
                Arrays.asList(7, 9, 6), // 3s
                Arrays.asList(5, 6, 4), // 3b
        };
        int[][] results = {
                {1, 1},
                {0, 0},
                {0, 3},
                {3, 0}
        };
        for (int i = 0; i < computers.length; i++){
            Map<String, Integer> result = game.countBallsAndStrikes(computers[i], users[i]);
            int ballCount = result.getOrDefault("볼", 0);
            int strikeCount = result.getOrDefault("스트라이크", 0);

            assertThat(ballCount).isEqualTo(results[i][0]);
            assertThat(strikeCount).isEqualTo(results[i][1]);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
