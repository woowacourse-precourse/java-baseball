package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_랜덤숫자_크기_테스트() throws Exception {
        GameManager gameManager = new GameManager();

        int result = 3;
        gameManager.createComputerBaseballNumber();

        Field randomNumberFiled = gameManager.getClass().getDeclaredField("computerBaseballNumber");
        randomNumberFiled.setAccessible(true);
        List<Integer> computerRandomNumbers = (List<Integer>) randomNumberFiled.get(gameManager);

        assertThat(computerRandomNumbers.size()).isEqualTo(result);
    }

    @Test
    void 컴퓨터_랜덤값_숫자인지_확인() throws Exception {
        GameManager gameManager = new GameManager();

        gameManager.createComputerBaseballNumber();
        Field randomNumberFiled = gameManager.getClass().getDeclaredField("computerBaseballNumber");
        randomNumberFiled.setAccessible(true);
        List<Integer> computerRandomNumbers = (List<Integer>) randomNumberFiled.get(gameManager);


        assertThat(computerRandomNumbers.stream().allMatch(number -> number >= 1 && number <= 9)).isTrue();
    }
}
