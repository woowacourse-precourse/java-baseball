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
    void 입력시오류경우_확인(){

        /**
         * 숫자 중복의 경우
         */
        Assertions.assertThatThrownBy(() -> Domain.isInputAlright("122")).isInstanceOf(IllegalArgumentException.class);

        /**
         * 숫자의 길이가 3보다 큰 경우
         */
        Assertions.assertThatThrownBy(() ->{
            Domain.isInputAlright("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        /**
         * 숫자의 길이가 3보다 작은 경우
         */
        Assertions.assertThatThrownBy(() ->{
            Domain.isInputAlright("12");
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
        List<Integer> strikeBall = Game.findStrikeBall(computerNumber, userNumberList
                );

        strike = strikeBall.get(0);
        ball = strikeBall.get(1);
        Assertions.assertThat(strike).isEqualTo(3);


        /**
         * 2볼 1스트라이크
         */
        List<Integer> computerNumber2 = Arrays.asList(3,1,2);
        List<Integer> userNumberList2 = Arrays.asList(1,3,2);
        int strike2=0;
        int ball2=0;
        List<Integer> strikeBall2 = Game.findStrikeBall(computerNumber2, userNumberList2
            );

        strike2 = strikeBall2.get(0);
        ball2 = strikeBall2.get(1);
        Assertions.assertThat(ball2).isEqualTo(2);


        /**
         * 1볼 1스트라이크
         */
        List<Integer> computerNumber3 = Arrays.asList(1,2,4);
        List<Integer> userNumberList3 = Arrays.asList(1,4,3);
        int strike3=0;
        int ball3=0;
        List<Integer> strikeBall3 = Game.findStrikeBall(computerNumber3, userNumberList3
           );

        strike3 = strikeBall3.get(0);
        ball3 = strikeBall3.get(1);
        Assertions.assertThat(ball3).isEqualTo(1);


        /**
         * 3볼 0스트라이크
         */
        List<Integer> computerNumber4 = Arrays.asList(1,3,2);
        List<Integer> userNumberList4 = Arrays.asList(2,1,3);
        int strike4=0;
        int ball4=0;
        List<Integer> strikeBall4 = Game.findStrikeBall(computerNumber4, userNumberList4
          );

        strike4 = strikeBall4.get(0);
        ball4 = strikeBall4.get(1);
        Assertions.assertThat(strike4).isEqualTo(0);
    }


    @Test
    void 게임종료_재시작체크(){
        Integer userDecisionException = 3;
        Assertions.assertThatThrownBy(() -> isGameOver(userDecisionException, 1, 2)).isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    void 사용자와컴퓨터List에들어갔는지(){

        List<Integer> user = Domain.inputProcess("123");
        List<Integer> compute = Domain.computerRandomNumberExtract();

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
