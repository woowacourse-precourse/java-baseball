package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CLOSE_MESSAGE = "게임을 완전히 종료합니다.";
    private static final String OVER_THREE = "3자리 이상을 입력하였습니다.";
    private static final String NOT_NUMBER = "숫자가 아닌 다른 문자를 입력하였습니다.";
    private static final String DUPLICATE_NUMBER = "중복된 숫자를 입력하였습니다.";
    private static final String NOT_1_AND_2 = "1과 2를 제외한 값을 입력하였습니다.";
    private static final String NOTHING = "낫싱";
    private static final String BALL_STRIKE = "%d볼 %d스트라이크\n";
    private static final String BALL = "%d볼\n";
    private static final String STRIKE = "%d스트라이크\n";
    private static final String ALL_STRIKE = "%d스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";


    public void start() {
        System.out.println(START_MESSAGE);
        List<Integer> computerNumber = makeRandomNum();

        boolean gameContinue = true;

        while (gameContinue) {

            boolean gameRestart = false;

            System.out.println(INPUT_MESSAGE);
            String userInput = Console.readLine();

            checkUserInput(userInput);
            List<Integer> userNumber = convertInput(userInput);

            int strike = countStrike(computerNumber, userNumber);
            int ball = countBall(computerNumber, userNumber);

            gameContinue = checkResult(strike, ball);

            if (!gameContinue) gameRestart = checkRestart();

            if (gameRestart) {
                gameContinue = true;
                computerNumber = makeRandomNum();
            }
        }
    }

    // 랜덤 숫자 만들기
    public List<Integer> makeRandomNum() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public void checkUserInput(String user) {

        if (user.length() != 3) throw new IllegalArgumentException(OVER_THREE);

        if (isNotNumber(user)) throw new IllegalArgumentException(NOT_NUMBER);

        if (isDuplicateNum(user)) throw new IllegalArgumentException(DUPLICATE_NUMBER);

    }

    public boolean isNotNumber(String input) {

        String numberString = "123456789";

        for (int i = 0; i < 3; i++) {

            if (numberString.contains(input.substring(i,i+1))) continue;

            return true;
        }

        return false;
    }

    public boolean isDuplicateNum(String input) {

        char[] numberArray = {'1','2','3','4','5','6','7','8','9'};

        for (char num : numberArray) {

            if (countNum(input, num) > 1) return true;
        }

        return false;
    }

    public int countNum(String input, char num) {

        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == num) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> convertInput(String userInput) {

        List<Integer> newInput = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            newInput.add(userInput.charAt(i) - '0');
        }

        return newInput;
    }

    public int countStrike(List<Integer> computer, List<Integer> user) {

        int strike = 0;

        for (int i = 0; i < 3; i++) {

            if (computer.get(i) == user.get(i)) strike++;
        }

        return strike;
    }

    public int countBall(List<Integer> computer, List<Integer> user) {

        int ball = 0;

        for (int i = 0; i < 3; i++) {

            int computerNum = computer.get(i);

            ball += checkBall(i, computerNum, user);
        }

        return ball;
    }

    public int checkBall(int computerIndex, int computerNumber, List<Integer> user) {

        int count = 0;

        for (int i = 0; i < 3; i++) {

            if (computerIndex == i) continue;

            if (computerNumber == user.get(i)) count++;
        }

        return count;
    }

    public boolean checkResult(int strike, int ball) {

        if (strike + ball == 0) {
            System.out.println(NOTHING);
        } else if (strike > 0 && ball > 0) {
            System.out.printf(BALL_STRIKE, strike, ball);

        } else if (ball > 0) {
            System.out.printf(BALL, ball);

        } else if (strike > 0 && strike < 3) {
            System.out.printf(STRIKE, strike);

        } else if (strike == 3) {
            System.out.printf(ALL_STRIKE, strike);
            return false;
        }

        return true;
    }

    public boolean checkRestart() {

        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();

        if (input.length() != 1 || (input.charAt(0) != '1' && input.charAt(0) != '2'))
            throw new IllegalArgumentException(NOT_1_AND_2);

        if (input.charAt(0) == '1') return true;
        else if (input.charAt(0) == '2') System.out.println(CLOSE_MESSAGE);

        return false;
    }
}
