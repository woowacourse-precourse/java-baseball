package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.Application.GAME_OVER;
import static baseball.Application.RESTART;
import static baseball.Application.getUserDecision;
import static baseball.Application.isGameOver;
import static baseball.Application.playGame;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    /**
     *  아직 기능 목록 구현마다의 테스트 작성 남음. 4번 기능 테스트 목록 작성해야함. 5번도 마찬가지
     */
    @Test
    void 입력시오류경우_확인(){

        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("122");
            }).isInstanceOf(IllegalArgumentException.class);


        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("12");
        }).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 스트라이크볼판정_findStrike검증(){
        /**
         * 3스트라이크
         */
        List<Integer> computerNumber = Arrays.asList(1,3,2);
        List<Integer> userNumberList = Arrays.asList(1,3,2);
        int strike=0;
        int ball=0;
        List<Integer> strikeBall = Application.findStrikeBall(computerNumber, userNumberList,
                strike, ball);

        strike = strikeBall.get(0);
        ball = strikeBall.get(1);
        System.out.println("strikeBall = " + strikeBall);
        Assertions.assertThat(strike).isEqualTo(3);


        /**
         * 2볼 1스트라이크
         */
        List<Integer> computerNumber2 = Arrays.asList(3,1,2);
        List<Integer> userNumberList2 = Arrays.asList(1,3,2);
        int strike2=0;
        int ball2=0;
        List<Integer> strikeBall2 = Application.findStrikeBall(computerNumber2, userNumberList2,
            strike2, ball2);

        strike2 = strikeBall2.get(0);
        ball2 = strikeBall2.get(1);
        System.out.println("strikeBall = " + strikeBall2);
        Assertions.assertThat(ball2).isEqualTo(2);


        /**
         * 1볼 1스트라이크
         */
        List<Integer> computerNumber3 = Arrays.asList(1,2,4);
        List<Integer> userNumberList3 = Arrays.asList(1,4,3);
        int strike3=0;
        int ball3=0;
        List<Integer> strikeBall3 = Application.findStrikeBall(computerNumber3, userNumberList3,
            strike3, ball3);

        strike3 = strikeBall3.get(0);
        ball3 = strikeBall3.get(1);
        System.out.println("strikeBall = " + strikeBall3);
        Assertions.assertThat(ball3).isEqualTo(1);


        /**
         * 3볼 0스트라이크
         */
        List<Integer> computerNumber4 = Arrays.asList(1,3,2);
        List<Integer> userNumberList4 = Arrays.asList(2,1,3);
        int strike4=0;
        int ball4=0;
        List<Integer> strikeBall4 = Application.findStrikeBall(computerNumber4, userNumberList4,
            strike4, ball4);

        strike4 = strikeBall4.get(0);
        ball4 = strikeBall4.get(1);
        System.out.println("strikeBall = " + strikeBall4);
        Assertions.assertThat(strike4).isEqualTo(0);
    }


    @Test
    void 게임종료_재시작체크(){
        Integer userDecisionException = 3;
        Assertions.assertThatThrownBy(() -> isGameOver(userDecisionException, 1, 2)).isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    void 사용자와컴퓨터List에들어갔는지(){

        List<Integer> user = Application.inputProcess("123");
        List<Integer> compute = Application.computerRanmdomNumberExtract();

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
