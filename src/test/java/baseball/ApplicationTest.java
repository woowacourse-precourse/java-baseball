package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 유효한_컴퓨터_랜덤_숫자(){
        Game game = new Game();
        int[] number = game.number;
        assertThat(number.length).isEqualTo(3);
    }

    @Test
    void 유효하지않은_컴퓨터_랜덤_숫자(){
        Game game = new Game();
        int[] number = game.number;
        assertThat(number.length).isNotEqualTo(1);
    }

    @Test
    void 사용자_입력값_3글자(){
        String num = "123";
        boolean result = Game.isLengthThree(num);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 사용자_입력값_모두_숫자(){
        String num = "123";
        boolean result = Game.isInputNumber(num);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 사용자_입력값_중복_제거(){
        String num="125";
        boolean result = Game.isEqualNumber(num);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 볼_스크라이크_점수_계산(){
        String num = "123";
        String computer ="321";
        Hint hint = new Hint();
        Game answer = new Game(num);
        Game com = new Game(computer);
        int[] result = hint.hintResult(com,answer);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(1);

    }

    @Test
    void 모두_스크라이크_점수_계산(){
        String num = "123";
        String computer = "123";
        Game answer = new Game(num);
        Game com = new Game(computer);
        Hint hint = new Hint();
        int[] result = hint.hintResult(com,answer);
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(3);
    }

    @Test
    void 유효한_게임시작_번호(){
        String input = "1";
        int result = Game.getNewGameAnswer(input);
        assertThat(result).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
