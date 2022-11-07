package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
    void getPlayerNumberInListTest() {
        String playerNumber = "123";
        List<Integer> playerNumberList =
                Arrays.stream(playerNumber.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        assertThat(playerNumberList).containsExactly(1, 2, 3);
    }

    @Test
    void validatePlayerNumberTest(){
        List<Integer> playerNumberList = Arrays.asList(1,2,3);

        assertThat(playerNumberList).hasSize(3);
        assertThat(playerNumberList.get(0)).isBetween(1,9);
        assertThat(playerNumberList.get(1)).isBetween(1,9);
        assertThat(playerNumberList.get(2)).isBetween(1,9);
    }

    @Test
    void computeResultTest(){
        List<Integer> computerNumberList = Arrays.asList(1,2,3);
        List<Integer> playerNumberList = Arrays.asList(3,2,5);
        List<Integer> resultList = new ArrayList<>(Arrays.asList(0, 0));

        for (int i = 0; i < computerNumberList.size(); i++) {
            int index = playerNumberList.indexOf(computerNumberList.get(i));
            if (index < 0) {
                continue;
            } else if (index != i) {
                resultList.set(0, resultList.get(0) + 1);
            } else {
                resultList.set(1, resultList.get(1) + 1);
            }
        }
        assertThat(resultList).containsExactly(1,1);
    }

    @Test
    void printResultTest(){
        List<Integer> resultList = Arrays.asList(1,1);
        String gameResult = "";

        if (resultList.get(0) > 0) {
            gameResult = gameResult + resultList.get(0).toString() + "볼 ";
        }
        if (resultList.get(1) > 0) {
            gameResult = gameResult + resultList.get(1).toString() + "스트라이크";
        }
        if (resultList.get(0) == 0 & resultList.get(1) == 0) {
            gameResult = gameResult + "낫싱";
        }
        assertThat(gameResult).isEqualTo("1볼 1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
