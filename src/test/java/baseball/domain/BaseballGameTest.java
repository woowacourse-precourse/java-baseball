package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest extends NsTest {

    @Test
    void play_메서드로_플레이어의_예상숫자가_컴퓨터숫자와_다르면_다시_입력받기() {
        assertSimpleTest(
                () -> {
                    run("123", "146");
                    assertThat(output()).contains("숫자를 입력해주세요 : ", "숫자를 입력해주세요 : ", "게임 종료");
                }
        );
    }

    @Override
    public void runMain() {
        List<Integer> computerNumbers = Arrays.asList(1,4,6);
        BaseballGame game = new BaseballGame(computerNumbers);
        game.play();
    }
}