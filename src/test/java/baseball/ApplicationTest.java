package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    //입력값 입력.
                    //run => 인자값들을 입력값으로 바꾸고 Application을 실행시킴.
                    //Application의 출력값이 각각 아래와 같다면 테스트가 통과하는 형식...?
                    run("246", "135", "1", "597", "589", "2"); //1:게임 재시작 2:게임 종료
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },

                1, 3, 5, 5, 8, 9  //정답 숫자가 135 -> 589 로 바뀜..
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
    void 스트라이크개수_볼_개수_구하기() {
        int[] score = new int[2];

        List<Integer> computer_num = new ArrayList<>();

        computer_num.add(5);
        computer_num.add(7);
        computer_num.add(9);

        String answer = "759";

        score[0] = Application.checkStrike(computer_num,answer);
        score[1] = Application.checkBall(computer_num,answer);

        assertThat(score).containsExactly(1,2);

    }

    @Test
    void 점수에_따른_출력값_테스트() {
        List<Integer> computer_num = new ArrayList<>();

        computer_num.add(1);
        computer_num.add(3);
        computer_num.add(9);

        String answer = "267";
        String answer2 = "192";

        int strike = Application.checkStrike(computer_num, answer);
        int ball = Application.checkBall(computer_num, answer);

        int strike2 = Application.checkStrike(computer_num, answer2);
        int ball2 = Application.checkBall(computer_num, answer2);


        Application.printResult(strike,ball);
        Application.printResult(strike2,ball2);

        assertThat(output()).contains("낫싱","1볼 1스트라이크");


    }



    @Test
    void 정답을_맞출_경우_선택지_테스트() {

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Application.askContinue();
        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료","게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


        String input2 = "6";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        assertThatThrownBy(() -> Application.askContinue())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 1,2중 하나로 입력해야 합니다.");




    }

    @Test
    void 사용자_입력_유효성_테스트(){

        String[] answer = {"999", "a23"};

        for (String a: answer){
            assertThatThrownBy(() -> Application.checkAnswer(a))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3자리의 서로 다른 자연수를 입력하여 주세요.");
        }


    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }



}



