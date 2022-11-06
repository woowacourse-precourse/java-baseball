package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberBaseballGameServerTest {

    @Test
    void 게임숫자는_3자리의_숫자입니다() {
        List<Integer> gameNumberList = new NumberBaseballGameServer().makeNewGameNumber();
        int gameNumberList_ExpectedSize = 3;
        assertThat(gameNumberList.size()).isEqualTo(gameNumberList_ExpectedSize);
    }

    @Test
    void 게임숫자는_서로_다른_숫자로_구성되어_있습니다() {
        List<Integer> gameNumberList = new NumberBaseballGameServer().makeNewGameNumber();
        boolean expected = false;

        while (gameNumberList.size() != 0) {
            int degreeNumber = gameNumberList.remove(0);
            assertThat(gameNumberList.contains(degreeNumber)).isEqualTo(expected);
        }
    }

}