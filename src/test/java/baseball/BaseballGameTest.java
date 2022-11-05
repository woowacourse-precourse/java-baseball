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

    @Test
    void isIllegalInputTest() {
        BaseballGame game = new BaseballGame();

        int num1 = 1422;
        int num2 = 993;
        int num3 = 152;

        Boolean result1 = game.isIllegalGameInput(num1);
        Boolean result2 = game.isIllegalGameInput(num2);
        Boolean result3 = game.isIllegalGameInput(num3);


        assertThat(result1).isEqualTo(Boolean.FALSE);
        assertThat(result2).isEqualTo(Boolean.FALSE);
        assertThat(result3).isEqualTo(Boolean.TRUE);
    }

    @Test
    void checkDuplicateNumTest() {
        BaseballGame game = new BaseballGame();

        int num1 = 152;
        int num2 = 993;
        int num3 = 444;

        Boolean result1 = game.checkDuplicateNums(num1);
        Boolean result2 = game.checkDuplicateNums(num2);
        Boolean result3 = game.checkDuplicateNums(num3);

        assertThat(result1).isEqualTo(Boolean.FALSE);
        assertThat(result2).isEqualTo(Boolean.TRUE);
        assertThat(result3).isEqualTo(Boolean.TRUE);
    }
}