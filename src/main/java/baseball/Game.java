package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String BALL = "볼";
    static final String SPACE = " ";
    static final String STRIKE = "스트라이크";
    static final String CORRECT_ANSWER = "3스트라이크";
    static final String NOTHING = "낫싱";
    static final String INPUT_QUESTION = "숫자를 입력해주세요 : ";
    static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
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
        System.out.print(INPUT_QUESTION);
        String numberStr = readLine();
        checkInputValidation(numberStr);
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
            result = ball + BALL + SPACE + strike + STRIKE;
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
        System.out.println(FINISH_MESSAGE);
        System.out.println(FINISH_QUESTION);
        String num = readLine();
        if (num.equals("1")) {
            return false;
        } else {
            return true;
        }
    }
    public void play() {
        printStartMessage();
        List<Integer> computer = createComputerNumber();
        List<Integer> user = null;

        while (true) {
            user = inputUserNumber();
            String result = getResult(computer, user);
            System.out.println(result);
            boolean answer = isAnswer(result);

            if (!answer) continue;

            if (!isFinish()) {
                replay();
            }
            break;
        }
    }
    public void replay(){
        play();
    }
    public void checkInputValidation(String numberStr){
        if (numberStr.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            int cur = numberStr.charAt(i) - '0';
            if (cur < 1 || cur > 9) {
                throw new IllegalArgumentException();
            }
        }

        int firstNumber = numberStr.charAt(0);
        int secondNumber = numberStr.charAt(1);
        int thirdNumber = numberStr.charAt(2);

        if (firstNumber == secondNumber || firstNumber == thirdNumber || secondNumber == thirdNumber) {
            throw new IllegalArgumentException();
        }
    }
}
