package baseball;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @BeforeEach
    void initData() {
        GameService gameService = new GameService();
        gameService.initData();
    }
    @Test
    void 입력수_숫자로만_존재하는지() {
        String inputBalls = "123";
        boolean checkNumeric = inputBalls.matches("[+-]?\\d*(\\.\\d+)?");
        if(!checkNumeric){
            throw new IllegalArgumentException();
        }
    }
    @Test
    void 랜덤수_중복유무_체크() {
        GameService gameService = new GameService();

        List<Integer> randomBalls;
        boolean doubleCheck = true;
        randomBalls = gameService.makeRandomBall();

        if (randomBalls.get(0).equals(randomBalls.get(1))) doubleCheck = false;
        if (randomBalls.get(1).equals(randomBalls.get(2))) doubleCheck = false;
        if (randomBalls.get(0).equals(randomBalls.get(2))) doubleCheck = false;

        assertThat(true).isEqualTo(doubleCheck);
    }
    @Test
    void 랜덤수_자릿수_체크() {
        GameService gameService = new GameService();

        int checkIndex = 0;
        List<Integer> checkSize;
        checkSize = gameService.makeRandomBall();

        for(int i : checkSize) {
            checkIndex++;
        }
        assertThat(checkSize.size()).isEqualTo(checkIndex);
    }
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
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
