package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class NumberBaseballGameTest extends NsTest {
    @Test
    void getComputerNumber_3자리의_수를_랜덤으로_선택하는_기능() {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        List<Integer> computerNumber = numberBaseballGame.getComputerNumber();
        assertThat(computerNumber.get(0) != computerNumber.get(1)).isTrue();
        assertThat(computerNumber.get(0) != computerNumber.get(2)).isTrue();
        assertThat(computerNumber.get(1) != computerNumber.get(2)).isTrue();

        assertThat(computerNumber.get(0) >= 1 && computerNumber.get(0) <= 9).isTrue();
        assertThat(computerNumber.get(1) >= 1 && computerNumber.get(1) <= 9).isTrue();
        assertThat(computerNumber.get(2) >= 1 && computerNumber.get(2) <= 9).isTrue();
    }

    @Test
    void calculateStrikeAndBall_입력한_숫자에_대한_strike와_ball의_결과를_계산하는_기능(){
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        List<Integer> computerNumber1 = List.of(1, 5, 7);
        List<Integer> playerNumber1 = List.of(1, 7, 9);
        assertThat(numberBaseballGame.calculateStrikeAndBall(computerNumber1, playerNumber1).get(0)).isEqualTo(1);
        assertThat(numberBaseballGame.calculateStrikeAndBall(computerNumber1, playerNumber1).get(1)).isEqualTo(1);

        List<Integer> computerNumber2 = List.of(1, 5,7);
        List<Integer> playerNumber2 = List.of(1, 5, 7);
        assertThat(numberBaseballGame.calculateStrikeAndBall(computerNumber2, playerNumber2).get(0)).isEqualTo(3);
        assertThat(numberBaseballGame.calculateStrikeAndBall(computerNumber2, playerNumber2).get(1)).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
