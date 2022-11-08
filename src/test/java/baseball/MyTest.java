package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.spy;

public class MyTest extends NsTest {

    @Test
    void 컴퓨터가_다른_3가지수_선택() {
        List<Integer> spyList = spy(Computer.class).setComputer();

        assertThat(spyList.size()).as("out of range").isEqualTo(3);
    }

    @Test
    void 사용자가_입력한_값이_예외인가() {
        List<Integer> userListError = Arrays.asList(2, 2, 3);
        List<Integer> userListNormal = Arrays.asList(1, 2, 3);
        List<Integer> userListOne = List.of(1);


        assertThatThrownBy( () -> spy(UserException.class).checkUserHasException(userListError) )
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode( () -> spy(UserException.class).checkUserHasException(userListNormal) )
                .doesNotThrowAnyException();
        assertThatCode( () -> spy(UserException.class).checkUserHasException(userListOne) )
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 볼인지_스트라이크인지_확인() {
        List<Integer> computer = Arrays.asList(1, 2, 3);

        List<Integer> oneBall = Arrays.asList(5, 1, 6);
        List<Integer> oneBalloneStrike = Arrays.asList(3, 2, 6);
        List<Integer> endOfGame = Arrays.asList(1, 2, 3);

        assertThat( spy(BallOrStrike.class).countStrikeBall(oneBall, computer) )
                .as("볼만 있는 쪽 다시 체크")
                .isEqualTo(false);

        assertThat( spy(BallOrStrike.class).countStrikeBall(oneBalloneStrike, computer) )
                .as("볼이랑 스트라이크 있는 쪽 다시 체크")
                    .isEqualTo(false);
        assertThat( spy(BallOrStrike.class).countStrikeBall(endOfGame, computer) )
                .as("스트라이크 있는 쪽 다시 체크")
                    .isEqualTo(true);

    }

    @Test
    void 일혹은이_입력하지_않으면_예외발생하는지_체크() {
        int normal = 1;
        int error1 = 5;
        int error2 = 11;

        assertThat(spy(UserEndGameException.class).checkUserHasOneOrTwo(normal)).as("5러규").isEqualTo(1);

        assertThatThrownBy( () -> spy(UserEndGameException.class).checkUserHasOneOrTwo(error1) )
                .as("예외")
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy( () -> spy(UserEndGameException.class).checkUserHasOneOrTwo(error2) )
                .as("예외")
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode( () -> spy(UserEndGameException.class).checkUserHasOneOrTwo(normal) )
                .as("보통")
                .doesNotThrowAnyException();


    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
