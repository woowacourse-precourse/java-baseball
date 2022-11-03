package baseball.domain;

import java.util.ArrayList;

public class Game {
    private static String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private static String NOTHING = "낫싱";
    private static String IS_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static int IS_ANSWER = 3;
    private static int IS_NONE = 0;
    private int strike;
    private int ball;
    private static boolean status = true;
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
        }
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
