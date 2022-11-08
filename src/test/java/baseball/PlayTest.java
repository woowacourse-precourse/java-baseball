package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.player.Computer;
import baseball.player.User;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class PlayTest extends NsTest {

    Play play = new Play(new User(new Validation()), new Computer(), new Hint());

    @Test
    void 재시작_예외_확인() {
        //given
        run("3");
        //when
        Throwable throwable = catchThrowable(() -> play.isRestart());
        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }



    @Override
    public void runMain() {
    }
}