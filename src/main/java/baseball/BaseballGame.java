package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class BaseballGame {
    private ArrayList<Integer> comAnswer = new ArrayList<>();
    private ArrayList<Integer> userAnswer = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;


    private void initAnswer() {
        comAnswer = new ArrayList<>();
        while (comAnswer.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);

            if (comAnswer.indexOf(randomInt) == -1)
                comAnswer.add(randomInt);
        }
        System.out.println(comAnswer);
    }

    public void inputAnswer() {
        userAnswer = new ArrayList<>();

        System.out.print("숫자를 입력하주세요 : ");

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


    public void checkAnswer() {
        strike = 0;
        ball = 0;

        for (int i = 0; i < 3; i ++) {
            int num = userAnswer.get(i);
            // 자리수별로 스트라이크, 볼 판별
            int status = checkValue(num, i);

            // 결과 저장
            if (status == 2)
                strike += 1;
            else if (status == 1)
                ball += 1;
        }
    }


    private void endPhase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

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
            processGame();
    }


    void printResult() {
        if (strike == 0 && ball == 0)
            System.out.println("낫싱\n");
        else if (strike == 0)
            System.out.printf("%d볼\n", ball);
        else if (ball == 0)
            System.out.printf("%d스트라이크\n", strike);
        else
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }


    private void processGame() {
        initAnswer();
        while (true) {
            inputAnswer();
            checkAnswer();
            printResult();

            if (strike == 3)
                break;
        }
        endPhase();
    }


    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        processGame();
    }
}

