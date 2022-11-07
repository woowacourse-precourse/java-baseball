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

    public ArrayList<Integer> inputAnswer() {
        ArrayList<Integer> userAnswer = new ArrayList<>();

        String line = Console.readLine();
        char[] chars = line.toCharArray();

        // 길이 검사 >> 만약 3이 아니면
        if (chars.length != 3)
            throw new IllegalArgumentException();

        for (char c : chars) {
            // 숫자 여부 검사
            if (!Character.isDigit(c))
                throw new IllegalArgumentException();

            int num = Character.getNumericValue(c);

            // 범위 검사 (1 ~ 9)
            if (num < 1)
                throw new IllegalArgumentException();

            // 중복값 검사
            if (userAnswer.indexOf(num) != -1)
                throw new IllegalArgumentException();

            userAnswer.add(num);
        }

        return userAnswer;
    }

    private int checkValue(int value, int digit) {

        for (int i = 0; i < 3; i ++) {
            int comValue = comAnswer.get(i);

            // 자리수와 값이 같을 경우 > 스트라이크
            if ((value == comValue) && (digit == i))
                return 2;

            // 값만 같을 경우 > 볼
            else if ((value == comValue))
                return 1;
        }

        return 0;
    }


    public int[] checkAnswer(ArrayList<Integer> userAnswer) {
        int[] result = {0, 0};

        for (int i = 0; i < 3; i ++) {
            int num = userAnswer.get(i);
            // 자리수별로 스트라이크, 볼 판별
            int status = checkValue(num, i);

            // 결과 저장
            if (status == 2)
                result[0] += 1;
            else if (status == 1)
                result[1] += 1;
        }

        return result;
    }


    void endGame() {
        String line = Console.readLine();
        char[] chars = line.toCharArray();

        // 자리수 검사
        if (chars.length != 1)
            throw new IllegalArgumentException();
        char c = chars[0];

        // 숫자인지 판별
        if (!Character.isDigit(c))
            throw new IllegalArgumentException();
        int num = Character.getNumericValue(c);

        // 범위 검사 (1 ~ 2)
        if (num < 1 || num > 2)
            throw new IllegalArgumentException();

        // 재시작일 경우
        if (num == 1)
            inputAnswer();

    }


}

