package baseball.domain;

import java.util.ArrayList;

public class Game {
    private static String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private int strike;
    private int ball;
    User user;
    Computer computer;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
    }

    public void Start() {
        while (true) {
            computer.createRandomNumbers();
            System.out.println(START_GAME);
            user.inputUserNumbers();
        }
    }

    public void outputHint(ArrayList<Integer> computer, ArrayList<Integer> user) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            strike += isStrike(computer.get(i), user.get(i));
            ball += isBall(computer,user.get(i),i);
        }
    }

    public int isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        return 0;
    }

    public int isBall(ArrayList<Integer> computer, int userNumber, int index) {
        if (computer.get(index) != userNumber && computer.contains(userNumber)){
            return 1;
        }
        return 0;
    }

}
