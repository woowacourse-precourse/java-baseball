package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String IS_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int IS_ANSWER = 3;
    private static final int IS_NONE = 0;
    private static final boolean status = true;
    private int strike;
    private int ball;
    User user;
    Computer computer;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
    }

    public void Start() {
        System.out.println(START_GAME);
        computer.createRandomNumbers();
        while (status) {
            user.inputUserNumbers();
            outputHint(computer.randomNumbers, user.userNumbers);
            if (isAnswer(strike)) {
                System.out.println(IS_CONTINUE);
            }
        }
    }

    public void outputRestart() {
        System.out.println(IS_CONTINUE);
        String answer = Console.readLine();

    }

    public void outputHint(ArrayList<Integer> computer, ArrayList<Integer> user) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            strike += isStrike(computer.get(i), user.get(i));
            ball += isBall(computer, user.get(i), i);
        }
        System.out.println(createOutput(strike, ball));
    }

    public int isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        return 0;
    }

    public int isBall(ArrayList<Integer> computer, int userNumber, int index) {
        if (computer.get(index) != userNumber && computer.contains(userNumber)) {
            return 1;
        }
        return 0;
    }

    public String createOutput(int strike, int ball) {
        if (strike == IS_ANSWER) {
            return strike + STRIKE;
        } else if (strike != IS_NONE && ball != IS_NONE) {
            return ball + BALL + " " + strike + STRIKE;
        } else if (strike > IS_NONE) {
            return strike + STRIKE;
        } else if (ball > IS_NONE) {
            return ball + BALL;
        } else {
            return NOTHING;
        }
    }

    public boolean isAnswer(int strike) {
        if (strike == IS_ANSWER) {
            return true;
        }
        return false;
    }

}
