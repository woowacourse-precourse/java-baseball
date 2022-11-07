package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Application.sc;

public class BaseballGame {
    private final List<Integer> answers = new ArrayList<>();
    private final List<Integer> inputs = new ArrayList<>();
    private int strike;
    private int ball;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        strike = 0;
        ball = 0;
        initAnswer();

        while (true) {
            inputNum();
            checkInput();
            if (showAndCheckResult()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void checkInput() {
        for (int i = 0; i < 3; i++) {
            if (inputs.get(i) == answers.get(i)) strike++;
            else if (answers.contains(inputs.get(i))) ball++;
        }
        inputs.clear();
    }

    private void inputNum() {
        System.out.printf("숫자를 입력해주세요 : ");
        try {
            String readLine = Console.readLine();
            int input = Integer.valueOf(readLine);
            mapAndValidateInput(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void mapAndValidateInput(int input) {
        if(input < 100 || input > 999){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            int digit = input % 10;
            if(digit == 0 || inputs.contains(digit)) throw new IllegalArgumentException();
            inputs.add(digit);
            input /= 10;
        }
        Collections.reverse(inputs);
    }

    private void initAnswer() {
        for (int i = 0; i < 3; i++) {
            int randInt = Randoms.pickNumberInRange(1, 9);
            if (answers.contains(randInt)) {
                i--;
                continue;
            }
            answers.add(randInt);
        }
    }

    private boolean showAndCheckResult() {
        if (strike + ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }

        if(strike == 3) return true;
        strike  = 0;
        ball = 0;
        return false;
    }
}
