package baseball.featureTest;

import baseball.PlayNumberBaseballGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class PlayNumberBaseballGameTest {
    PlayNumberBaseballGame playNumberBaseballGame = new PlayNumberBaseballGame();

    @Test
    void arrayList_setRandomNumberOfComputer() {
        List<Integer> randNum = playNumberBaseballGame.setRandomNumberOfComputer();
        assertThat(randNum)
                .isNotEmpty()
                .hasSize(3);
        assertThat(randNum.get(0))
                .isNotEqualTo(randNum.get(1))
                .isNotEqualTo(randNum.get(2));
        assertThat(randNum.get(1))
                .isNotEqualTo(randNum.get(2));
    }


}
