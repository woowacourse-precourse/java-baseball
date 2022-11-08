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
    void inGameTest_예외_네_개의_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inGameTest_예외_숫자가_아닌_입력(){

    }

    @Test
    void inGameTest_예외_0이_포함된_입력(){

    }

    @Test
    void inGameTest_예외_중복된_숫자_입력(){

    }

    @Test
    void endGameTest_예외_1이나_2가_아닌_숫자(){

    }

    @Test
    void endGameTest_예외_숫자가_아닌_입력(){

    }

    @Test
    void inGameTest_볼_갯수_세기(){

    }

    @Test
    void inGameTest_스트라이크_갯수_세기(){

    }

    @Test
    void inGameTest_매치되지_않음(){

    }

    @Test
    void inGameTest_정답_입력(){

    }

    @Test
    void inGameTest_생성된_숫자가_중복되지_않는_세자리_숫자(){

    }

    @Test
    void printTest_게임_시작_문구(){

    }

    @Test
    void printTest_정답_입력시_문구(){

    }

    @Test
    void printTest_볼_only_문구(){

    }

    @Test
    void printTest_스트라이크_only_문구(){

    }

    @Test
    void printTest_볼_and_스트라이크_문구(){

    }

    @Test
    void printTest_낫싱_문구(){

    }

    @Test
    void printTest_게임_재시작_문구(){

    }

    @Test
    void printTest_숫자_입력_요구_문구(){

    }


/*

    @Test
    void inGame_


    @Test
    void


    @Test
    void


    @Test
    void


    @Test
    void




*/


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
