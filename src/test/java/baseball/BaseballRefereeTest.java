package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballRefereeTest extends NsTest {
    @Test
    void isThreeStrike_Computer123Input123_true() {
        //given
        //when
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        BaseballReferee baseballReferee = new BaseballReferee(computer, input);
        //then
        assertThat(baseballReferee.isThreeStrike()).isEqualTo(true);
    }


    @Test
    void baseballReferee_Computer123Input456_낫싱() {
        //given
        //when
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(5);
        input.add(6);
        BaseballReferee baseballReferee = new BaseballReferee(computer, input);
        assertThat(output()).isEqualTo("낫싱");
        //then
    }

    @Test
    void countBall_Computer123Input216_2볼() {
        //given
        //when
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(1);
        input.add(6);
        BaseballReferee baseballReferee = new BaseballReferee(computer, input);
        //then
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    void countStrike_Computer123Input126_2스트라이크() {
        //given
        //when
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(6);
        BaseballReferee baseballReferee = new BaseballReferee(computer, input);
        //then
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Override
    protected void runMain() {
    }
}