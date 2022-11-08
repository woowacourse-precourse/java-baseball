package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomTest {

    @Test
    public void 비정상_입력_문제_발생_테스트() {
        String userInput1 = "1832";
        String userInput2 = "5a3";
        String userInput3 = "886";

        assertThat(Application.isUserInputLengthConstant(3, 3, userInput1)).isEqualTo(false);
        assertThat(Application.isUserInputNumeric(userInput2)).isEqualTo(false);
        assertThat(Application.isUserInputNotDuplicated(userInput3)).isEqualTo(false);
    }

    @Test
    public void 볼_스트라이크_테스트() {
        List<Integer> computer = Arrays.asList(4, 9, 3);
        List<List<Integer>> userInputs = Arrays.asList(Arrays.asList(4, 9, 3), Arrays.asList(1, 2, 5), Arrays.asList(4, 3, 9));
        List<Integer> answerList = Arrays.asList(1, 0, 2);

        for (int i = 0; i < userInputs.size(); i++) {
            List<Integer> userInput = userInputs.get(i);
            List<Integer> ballAndStrike = Application.getUserAnswerBallAndStrike(computer, userInput);
            int result = Application.getResult(ballAndStrike);

            assertThat(result).isEqualTo(answerList.get(i));
        }
    }

}
