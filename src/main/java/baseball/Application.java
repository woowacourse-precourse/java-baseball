package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        BaseballGame Game = new BaseballGame();

        Game.start();
    }
}

class BaseballGame {
    int hiddenNumber;

    public BaseballGame() {
        hiddenNumber = randomThreeDigitNumber();
    }


    /**
     * 1에서 9까지 서로 다른 임의의 수 3개를 선택
     */
    public static int randomThreeDigitNumber() {

        List<Integer> num_list = new ArrayList<>();
        Random random = new Random();
        int result = 0;

        while (num_list.size() < 3) {
            int new_random_number = random.nextInt(10);

            if (isValidRandomNumber(new_random_number, num_list)) {
                num_list.add(new_random_number);
            }
        }

        for (int number : num_list) {
            result = result * 10 + number;
        }

        return result;
    }

    /**
     * List에 들어가기에 적합한 숫자인지 확인한다.
     *
     * @param new_number: int
     * @param list:       list
     * @return boolean
     */
    public static boolean isValidRandomNumber(int new_number, List<Integer> list) {
        if (new_number == 0) {
            return false;
        }

        return !isDuplicated(new_number, list);
    }

    /**
     * 새로운 숫자가 list에 중복된 숫자가 있는지 확인한다.
     *
     * @param new_number:int
     * @param list:int
     * @return boolean
     */
    public static boolean isDuplicated(int new_number, List<Integer> list) {

        return list.contains(new_number);
    }


    /**
     * 숫자야구게임을 시작한다.
     */
    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playingGame = true;

        while (playingGame) {
            int userNumber = inputUserNumber();

            checkValidityOfNumber(userNumber);

            playingGame = computeResult(userNumber, hiddenNumber);

            if (!playingGame) {
                playingGame = askIfTerminate();
                handleIfRestart(playingGame);
            }
        }
    }

    public static boolean askIfTerminate() {
        Scanner scanner = new Scanner(System.in);
        int terminateFlag;
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            input = scanner.nextLine();
            terminateFlag = Integer.parseInt(input);

            checkValidityOfTerminateFlag(terminateFlag);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return terminateFlag == 1;
    }

    public static void checkValidityOfTerminateFlag(int terminateFlag) {
        if (terminateFlag != 1 && terminateFlag != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void handleIfRestart(boolean restart) {
        if(restart){
            this.hiddenNumber = randomThreeDigitNumber();
        }

    }

    public static int inputUserNumber() {
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        try {
            input = scanner.nextLine();
            userNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public static void checkValidityOfNumber(int input) {
        List<Integer> numList;
        numList = splitNumberByDigit(input);

        if (input < 100 || 999 < input) {
            throw new IllegalArgumentException();
        }

        if (numList.contains(0)) {
            throw new IllegalArgumentException();
        }

        if (isDuplicatedUserNumber(numList)) {
            throw new IllegalArgumentException();
        }

    }

    public static List<Integer> splitNumberByDigit(int number) {

        String strNumber = Integer.toString(number);
        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < strNumber.length(); i++) {
            resultList.add(strNumber.charAt(i) - '0');
        }

        return resultList;
    }

    public static boolean isDuplicatedUserNumber(List<Integer> numList) {
        int numSize = numList.size();
        for (int i = 0; i < numSize; i++) {
            int currentNumber = numList.get(i);
            if (numList.subList(i + 1, numSize).contains(currentNumber)) {
                return true;
            }
        }
        return false;
    }


    public static boolean computeResult(int userNumber, int hiddenNumber) {
        int strike;
        int ball;

        strike = computeStrike(userNumber, hiddenNumber);
        ball = computeBall(userNumber, hiddenNumber);

        return printResult(strike, ball);
    }

    public static int computeStrike(int userNumber, int hiddenNumber) {
        int strike = 0;
        List<Integer> userNumberList = splitNumberByDigit(userNumber);
        List<Integer> hiddenNumberList = splitNumberByDigit(hiddenNumber);

        for (int i = 0; i < 3; i++) {
            int currentUserNumber = userNumberList.get(i);
            int currentHiddenNumber = hiddenNumberList.get(i);

            if (currentUserNumber == currentHiddenNumber) {
                strike++;
            }
        }
        return strike;
    }

    public static int computeBall(int userNumber, int hiddenNumber) {
        int ball = 0;
        List<Integer> userNumberList = splitNumberByDigit(userNumber);
        List<Integer> hiddenNumberList = splitNumberByDigit(hiddenNumber);

        for (int i = 0; i < 3; i++) {
            int currentUserNumber = userNumberList.get(i);
            int currentHiddenNumber = hiddenNumberList.get(i);

            if (hiddenNumberList.contains(currentUserNumber) && currentUserNumber != currentHiddenNumber) {
                ball++;
            }
        }
        return ball;
    }

    public static boolean printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return false;
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball+"볼");
            return true;
        }
        if (strike !=0 && ball == 0) {
            System.out.println(strike+"스트라이크");
            return true;
        }
        if (strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return true;
        }
        System.out.println("낫싱");
        return true;
    }
}