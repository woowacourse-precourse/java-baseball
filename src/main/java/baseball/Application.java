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

    /**
     * 게임을 새로 시작할지, 종료할지를 처리한다.
     */
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

    /**
     * terminate flag 가 1 또는 2인지 확인한다
     * @param terminateFlag:int
     */
    public static void checkValidityOfTerminateFlag(int terminateFlag) {
        if (terminateFlag != 1 && terminateFlag != 2) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 게임을 재시작할지 확인 후 3자리 숫자를 다시 설정하여 게임을 재시작한다.
     * @param restart:boolean
     */
    public void handleIfRestart(boolean restart) {
        if(restart){
            this.hiddenNumber = randomThreeDigitNumber();
        }

    }

    /**
     * 사용자의 숫자를 입력받는다.
     * 이때 입력값이 정수인지 확인하여 예외처리한다.
     * @return userNumber:int
     */
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

    /**
     * 사용자가 입력한 숫자가 유효한지 확인한다.
     * 숫자의 범위(3자리의 수), 들어가있는 숫자(1부터 9까지), 숫자의 중복(서로 다른 수)
     * @param input:int
     */
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

    /**
     * 숫자의 자릿수마다 나눈 리스트를 반환한다
     * @param number:int
     * @return a list each element of which is digits of the number
     */
    public static List<Integer> splitNumberByDigit(int number) {

        String strNumber = Integer.toString(number);
        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < strNumber.length(); i++) {
            resultList.add(strNumber.charAt(i) - '0');
        }

        return resultList;
    }

    /**
     * 사용자가 입력한 숫자에 중복된 숫자가 있는지 확인한다.
     * @param numList:int
     * @return boolean
     */
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

    /**
     * 사용자가 입력한 값과 hiddenNumber 를 비교하여 strike 와 ball 을 계산한다.
     * 만약 사용자가 정답을 맞출 경우 false 가 반환되어 게임 종료상태로 들어간다.
     * @param userNumber:int
     * @param hiddenNumber:int
     * @return boolean
     */
    public static boolean computeResult(int userNumber, int hiddenNumber) {
        int strike;
        int ball;

        strike = computeStrike(userNumber, hiddenNumber);
        ball = computeBall(userNumber, hiddenNumber);

        return printResult(strike, ball);
    }

    /**
     * 같은 수가 같은 자리에 있으면 스트라이크
     * @param userNumber:int
     * @param hiddenNumber:int
     * @return strike
     */
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

    /**
     * 다른 자리에 있으면 볼
     * @param userNumber:int
     * @param hiddenNumber:int
     * @return ball:int
     */
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

    /**
     * strike, ball 을 출력하고 게임 종료 여부를 반환한다.
     * @param strike:int
     * @param ball:int
     * @return terminateFlag
     */
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
        // 같은 수가 전혀 없으면 낫싱
        System.out.println("낫싱");
        return true;
    }
}