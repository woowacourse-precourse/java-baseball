package baseball;

import baseball.Application.RunGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionImplementTest {
    @Test
    void 랜덤값_확인_테스트() {
        DataBase data = new DataBase();
        RunGame game = new RunGame();
        data.setAnswer(game.answer);
        assertThat(data.getAnswer())
            .hasSize(3);
    }
}
