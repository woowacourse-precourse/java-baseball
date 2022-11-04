package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

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

    // 기능 요구사항 1
    @Test
    void testFunction1_case1() {
        Computer computer =  new Computer();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void testFunction1_case2() {
        Computer computer =  new Computer();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers).isNotEmpty();
    }

    @Test
    void testFunction1_case3() {
        Computer computer =  new Computer();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(1));
        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(2));
        assertThat(randomNumbers.get(1)).isNotEqualTo(randomNumbers.get(2));
    }

    @Test
    void testFunction1_case4() {
        Computer computer =  new Computer();
        String randomNumbers = computer.getRandomNumbers().toString().replaceAll("[^0-9]", "");
        String pattern = "^[1-9]*$";

        assertThat(Pattern.matches(pattern, randomNumbers)).isTrue();
    }

    // 기능 요구사항 2
    @Test
    public void 게임_시작_안내_문구_출력() {
        assertThat(Game.GAME_START_GUIDE_MESSAGE).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    public void 게임플레이어의_숫자_입력() {

    }

    @Test
    public void 게임플레이어_입력_숫자_체크() {

    }

    @Test
    public void 숫자_입력에_대한_예외_판별() {

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
