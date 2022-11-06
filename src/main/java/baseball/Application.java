package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame Game = new BaseballGame();

        Game.start();


    }
}

class BaseballGame {
    int hiddenNumber;

    public BaseballGame() {
        System.out.println("Baseball_Game.Baseball_Game");

        hiddenNumber = randomThreeDigitNumber();
        System.out.println("hidden_number = " + hiddenNumber);

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
        System.out.println("num_list = " + num_list);

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

        while (true) {
            int userNumber = inputUserNumber();

            checkValidityOfNumber(userNumber);

            computeResult(userNumber, hiddenNumber);
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


    public static void computeResult(int userNumber, int hiddenNumber) {
        int strike;
        int ball;

        strike = computeStrike(userNumber, hiddenNumber);
        ball = computeBall(userNumber, hiddenNumber);
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
        System.out.println("strike = " + strike);
        return strike;
    }

    public static int computeBall(int userNumber, int hiddenNumber) {
        // TODO: ball 메소드 구현하기
        int ball = 0;



        return ball;
    }

}