package baseball;

import static baseball.Application.isGameOver;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {


    @Test
    void 입력시예외경우_확인() {

        /**
         * 숫자가 아닌 것을 입력한 경우
         */

        Domain domain = new Domain();
        Assertions.assertThatThrownBy(() -> domain.isInputAlright("A12"))
            .isInstanceOf(IllegalArgumentException.class);

        /**
         * 숫자 중복의 경우
         */
        Domain domain2 = new Domain();
        Assertions.assertThatThrownBy(() -> domain2.isInputAlright("122"))
            .isInstanceOf(IllegalArgumentException.class);

        /**
         * 숫자의 길이가 3보다 큰 경우
         */
        Domain domain3 = new Domain();
        Assertions.assertThatThrownBy(() -> {
            domain3.isInputAlright("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        /**
         * 숫자의 길이가 3보다 작은 경우
         */
        Domain domain4 = new Domain();
        Assertions.assertThatThrownBy(() -> {
            domain4.isInputAlright("12");
        }).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void Game_findStrike과정_출력문검증() {

        /**
         * 3스트라이크
         */
        List<Integer> computerNumber = Arrays.asList(1, 3, 2);
        List<Integer> userNumberList = Arrays.asList(1, 3, 2);
        int strike = 0;
        int ball = 0;
        Game game = new Game(computerNumber, userNumberList);
        List<Integer> strikeBall = game.findStrikeBall(computerNumber, userNumberList
        );

        strike = strikeBall.get(0);
        ball = strikeBall.get(1);
        Assertions.assertThat(strike).isEqualTo(3);

        /**
         * 2볼 1스트라이크
         */
        List<Integer> computerNumber2 = Arrays.asList(3, 1, 2);
        List<Integer> userNumberList2 = Arrays.asList(1, 3, 2);

        Game game2 = new Game(computerNumber2, userNumberList2);
        int strike2 = 0;
        int ball2 = 0;
        List<Integer> strikeBall2 = game2.findStrikeBall(computerNumber2, userNumberList2
        );

        strike2 = strikeBall2.get(0);
        ball2 = strikeBall2.get(1);
        game2.printGameResult(strike2, ball2);
        Assertions.assertThat(ball2).isEqualTo(2);

        /**
         * 1볼 1스트라이크
         */
        List<Integer> computerNumber3 = Arrays.asList(1, 2, 4);
        List<Integer> userNumberList3 = Arrays.asList(1, 4, 3);
        int strike3 = 0;
        int ball3 = 0;

        Game game3 = new Game(computerNumber3, userNumberList3);
        List<Integer> strikeBall3 = game3.findStrikeBall(computerNumber3, userNumberList3
        );
        strike3 = strikeBall3.get(0);
        ball3 = strikeBall3.get(1);
        game3.printGameResult(strike3, ball3);
        Assertions.assertThat(ball3).isEqualTo(1);

        /**
         * 3볼 0스트라이크
         */
        List<Integer> computerNumber4 = Arrays.asList(1, 3, 2);
        List<Integer> userNumberList4 = Arrays.asList(2, 1, 3);

        Game game4 = new Game(computerNumber4, userNumberList4);
        int strike4 = 0;
        int ball4 = 0;
        List<Integer> strikeBall4 = game4.findStrikeBall(computerNumber4, userNumberList4
        );

        strike4 = strikeBall4.get(0);
        ball4 = strikeBall4.get(1);
        game4.printGameResult(strike4, ball4);
        Assertions.assertThat(strike4).isEqualTo(0);

        /**
         * 0볼 n스트라이크 의 경우 출력문 확인
         */
        List<Integer> computerNumber5 = Arrays.asList(2, 1, 4);
        List<Integer> userNumberList5 = Arrays.asList(2, 1, 3);

        Game game5 = new Game(computerNumber5, userNumberList5);
        int strike5 = 0;
        int ball5 = 0;
        List<Integer> strikeBall5 = game5.findStrikeBall(computerNumber5, userNumberList5
        );
        strike5 = strikeBall5.get(0);
        ball5 = strikeBall5.get(1);
        game5.printGameResult(strike5, ball5);
        Assertions.assertThat(strike5).isEqualTo(2);

    }


    @Test
    void 게임종료_재시작예외체크() {
        Integer userDecisionException = 3;
        Assertions.assertThatThrownBy(() -> isGameOver(userDecisionException, 1, 2))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 사용자와컴퓨터List에들어갔는지() {

        Domain domain = new Domain();
        List<Integer> user = domain.inputProcess("123");
        List<Integer> compute = domain.computerRandomNumberExtract();

        Assertions.assertThat(user.size()).isEqualTo(3);
        Assertions.assertThat(compute.size()).isEqualTo(3);

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
