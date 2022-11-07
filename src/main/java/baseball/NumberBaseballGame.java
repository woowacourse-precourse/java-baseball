package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private List<Integer> computerNumber;
    private List<Integer> userNumber;
    private int strike;
    private int ball;

    public NumberBaseballGame() {
        computerNumber = new ArrayList<>();
        strike = 0;
        ball = 0;
        System.out.println(Constant.START_BASEBALL_GAME);
        getRandomThreeDigitNumber();
    }

    public void gameStart() {
        System.out.print(Constant.ENTER_NUMBER);
        String inputNumber = Console.readLine();
        userNumber = getUserNumberList(inputNumber);
        validateUserNumber();
        compareUserAndComputer();
        System.out.println(getResultToString());
    }

    public boolean checkGameEnd() {
        if (strike == 3) {
            System.out.println(Constant.CORRECT_ANSWER);
            System.out.println(Constant.SELECT_NEWGAME);
            String response = Console.readLine();
            if (response.equals(Constant.ONE)) {
                readyNewGame();
                return true;
            }
            if (response.equals(Constant.TWO)) {
                return false;
            }
            throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.ENTER_ONE_OR_TWO);
        }
        return true;
    }

    public void readyNewGame() {
        computerNumber.clear();
        getRandomThreeDigitNumber();
    }

    public void validateUserNumber() {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.ENTER_THREE_DIGIT_NUMBER);
        }
        if (userNumber.contains(0)) {
            throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.ENTER_EXCEPT_ZERO);
        }
        if (userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.NO_OVERLAP);
        }
    }

    public void getRandomThreeDigitNumber() {
        for (int i = 0; i < 3; ) {
            int num = Randoms.pickNumberInRange(Constant.MIN_RANGE_NUM, Constant.MAX_RANGE_NUM);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
                i++;
            }
        }
    }

    public List<Integer> getUserNumberList(String userNumber) {
        String[] userNumberArray = userNumber.split("");
        List<Integer> userNumberList = new ArrayList<>();
        for (String number : userNumberArray) {
            userNumberList.add(Integer.parseInt(number));
        }
        return userNumberList;
    }

    public void compareUserAndComputer() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.indexOf(userNumber.get(i)) == i) {
                strike++;
                continue;
            }
            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
    }

    public String getResultToString() {
        if (ball != 0 && strike != 0) {
            return ball + Constant.BALL + " " + strike + Constant.STRIKE;
        }
        if (ball != 0 && strike == 0) {
            return ball + Constant.BALL;
        }
        if (ball == 0 && strike != 0) {
            return strike + Constant.STRIKE;
        }
        return Constant.NOTHING;
    }

}
