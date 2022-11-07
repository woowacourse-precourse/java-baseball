package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class BaseballRefereeTest extends NsTest {
    @Test
    @DisplayName("3 스트라이크")
    void ThreeStrike() {
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
    @DisplayName("낫싱_테스트")
    void notThingTest() {
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
    @DisplayName("2 볼 테스트")
    void countBallTest() {
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
    @DisplayName("2 스트라이크 테스트")
    void countStrikeTest() {
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