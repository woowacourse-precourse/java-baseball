package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final String CORRECT_ANSWER = "3스트라이크";
    static final String NOTHING = "낫싱";
    static final String FINISH_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
    public List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public List<Integer> inputUserNumber() {
        String numberStr = readLine();
        List<Integer> user = new ArrayList<>();
        for (int i=0; i<3; i++) {
            user.add(numberStr.charAt(i)-'0');
        }
        return user;
    }
    public int checkStrike(List<Integer> computer, List<Integer> user) {
        int strike=0;
        for (int i=0; i<3; i++) {
            if (computer.get(i) == user.get(i)) strike++;
        }
        return strike;
    }
    public int checkBall(List<Integer> computer, List<Integer> user, int strike) {
        int ball=0;
        for (int i=0; i<3; i++) {
            if (computer.contains(user.get(i))) ball++;
        }
        return ball - strike;
    }
    public String getResult(List<Integer> computer, List<Integer> user) {
        int strike = checkStrike(computer, user);
        int ball = checkBall(computer, user, strike);

        String result;
        if (ball > 0 && strike > 0) {
            result = ball + BALL + strike + STRIKE;
        } else if (ball == 0 && strike > 0) {
            result = strike + STRIKE;
        } else if (ball > 0 && strike == 0) {
            result = ball + BALL;
        } else {
            result = NOTHING;
        }

        return result;
    }
    public boolean isAnswer(String result) {
        if (result.equals(CORRECT_ANSWER)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFinish() {
        System.out.println(FINISH_QUESTION);
        String num = readLine();
        if (num.equals("1")) {
            return false;
        } else {
            return true;
        }
    }
}
