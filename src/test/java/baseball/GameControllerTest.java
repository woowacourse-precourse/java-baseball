package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.view.InputViewConsole;
import baseball.view.OutputViewConsole;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

class GameControllerTest extends NsTest {
    @Test
    void randomTest10000() {
        for (int i = 0; i < 10000; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            String nothingString = getNothingString(randomNumbers);
            String threeBallString = getThreeBallString(randomNumbers);
            String answerString = ListToString(randomNumbers);

            assertRandomNumberInRangeTest(
                    () -> {
                        run(nothingString, threeBallString, answerString, "2");
                        assertThat(output()).contains("낫싱", "3볼", "3스트라이크", "게임 종료");
                    },
                    randomNumbers.get(0), randomNumbers.get(1), randomNumbers.get(2)
            );
        }
    }

    @Override
    protected void runMain() {
        GameController gc = new GameController(new InputViewConsole(), new OutputViewConsole());
        gc.run();
    }

    String ListToString(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numbers.get(0));
        stringBuilder.append(numbers.get(1));
        stringBuilder.append(numbers.get(2));
        return stringBuilder.toString();
    }

    String getThreeBallString(List<Integer> numbers) {
        List<Integer> numClone = new ArrayList<>(numbers);
        Integer num = numClone.remove(0);
        numClone.add(num);
        return ListToString(numClone);
    }

    String getNothingString(List<Integer> numbers) {
        List<Integer> nothing = new ArrayList<>();
        int randomNumber;
        while (nothing.size() != 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber) && !nothing.contains(randomNumber)) {
                nothing.add(randomNumber);
            }
        }
        return ListToString(nothing);
    }
}