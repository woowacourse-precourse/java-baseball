package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void generateRandomAnswerNumsTest() {
        BaseballGame game = new BaseballGame();

        List<Integer> randomNums = game.generateRandomAnswerNums();
        Collections.sort(randomNums);

        List<Integer> checkUnique = new ArrayList<>(new HashSet<>(randomNums));
        Collections.sort(checkUnique);

        assertThat(randomNums).isEqualTo(checkUnique);
        assertThat(randomNums.size()).isEqualTo(3);
    }
}