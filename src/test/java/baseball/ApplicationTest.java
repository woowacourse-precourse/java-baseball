package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
        // 컴퓨터 135, 589
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
        // 컴퓨터 135, 589
    void 게임종료_후_재시작_3() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "197", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
        // 컴퓨터 135, 589
    void 게임종료_후_재시작_2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("123", "589", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크",
                    "게임 종료");
            },
            5, 8, 9, 5, 8, 9
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
    void 예외_테스트_추가_1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_추가_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_추가_3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("qwe"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    void 예외_테스트_추가_4() {
//        GameView gameView = new GameView();
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("123", "589", "0");
//                assertThrows(IllegalArgumentException.class, gameView::run);
//            },
//            5, 8, 9, 5, 8, 9
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
