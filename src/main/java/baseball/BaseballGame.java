package baseball;

import java.util.*;

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
        System.out.println(answers);

        while (true) {
            inputNum();
            System.out.println(inputs);
            checkInput();
            if (showResult()) {
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
        Scanner sc = new Scanner(System.in);
        System.out.printf("숫자를 입력해주세요 : ");
        int input = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < 3; i++) {
            inputs.add(input % 10);
            input /= 10;
        }
        Collections.reverse(inputs);
    }

    private void initAnswer() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randInt = random.nextInt(9) + 1;
            if (answers.contains(randInt)) {
                i--;
                continue;
            }
            answers.add(randInt);
        }
    }

    private boolean showResult() {
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
