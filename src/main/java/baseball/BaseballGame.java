package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class BaseballGame {
    private ArrayList<Integer> comAnswer = new ArrayList<>();

    private void initAnswer() {
        while (comAnswer.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);

            if (comAnswer.indexOf(randomInt) == -1)
                comAnswer.add(randomInt);
        }
    }

    private ArrayList<Integer> inputAnswer() {
        ArrayList<Integer> userAnswer = new ArrayList<>();

        String line = Console.readLine();
        char[] chars = line.toCharArray();

        for (char c : chars) {
            // 숫자 여부 검사
            if (!Character.isDigit(c))
                throw new IllegalArgumentException();

            int num = Character.getNumericValue(c);

            // 중복값 검사
            if (userAnswer.indexOf(num) != -1)
                throw new IllegalArgumentException();

            userAnswer.add(num);
        }

        return userAnswer;
    }
}

