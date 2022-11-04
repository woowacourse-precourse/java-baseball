package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static baseball.Application.InputNumber;
import static baseball.Application.PickRandomNumber;

public class FunctionTest {
@Nested
class 랜덤으로숫자를뽑기{
    @Test
    void CreateRandomNumber() {
        List<Integer> Number =
                new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
                }
            }
        }
    }
    @Nested
    class 입력받은숫자를int배열로변환{
        @Test
        void ChangeUserNumber(){
            String num = "567";
            int UserChoiceNum[] = InputNumber(num);

        }
    }
}
