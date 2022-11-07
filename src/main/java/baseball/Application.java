package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean finishGame = false;

        while (!finishGame) {

            int answerNumber = getAnswerNumber();

            playGame(answerNumber);

            finishGame = continueOrExit();
        }
    }

    public static int getAnswerNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        System.out.println(computer); // TODO : 테스트용 출력! 지워야 함

        return computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
    }

    public static void playGame(int answerNumber) {

        boolean equalNumber = false;

        while (!equalNumber) {
            System.out.print("숫자를 입력해주세요 : ");

            int userNumber = getUserNumber();

            int strikes = countStrikes(userNumber, answerNumber);
            int balls = countBalls(userNumber, answerNumber);

            printResult(strikes, balls);

            equalNumber = threeStrikes(strikes);
        }
    }

    public static int getUserNumber() {

        String userString = Console.readLine();

        int userNumber;
        try {
            userNumber = Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }

        Set numberSet = new HashSet<>();
        for(int i=0; i<3; i++)
            numberSet.add(userString.charAt(i));

        if (numberSet.size() != 3 || userString.length() > 3)
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");

        return userNumber;
    }

    public static boolean continueOrExit() throws IllegalArgumentException {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int userChoice;
        try {
            userChoice = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        if (userChoice == 1)
            return false;
        if (userChoice == 2)
            return true;

        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    public static int countStrikes(int userNumber, int answerNumber) {

        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumber % 10 == answerNumber % 10) strikes += 1;

            userNumber /= 10;
            answerNumber /= 10;
        }

        return strikes;
    }

    public static int countBalls(int userNumber, int answerNumber) {

        int strikes = countStrikes(userNumber, answerNumber);

        int balls = 0;

        List<Integer> userDigits = new ArrayList<>();
        List<Integer> answerDigits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userDigits.add(userNumber % 10);
            answerDigits.add(answerNumber % 10);
            userNumber /= 10;
            answerNumber /= 10;
        }

        for (int i = 0; i < 3; i++) {

            int number = userDigits.get(i);
            if (answerDigits.contains(number))
                balls += 1;
        }

        return balls - strikes;
    }

    public static void printResult(int strikes, int balls) {

        if (strikes + balls == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strikes == 0 && balls != 0) {
            System.out.println(balls + "볼");
            return;
        }

        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
            return;
        }

        System.out.println(balls + "볼 " + strikes + "스트라이크");
    }

    public static boolean threeStrikes(int strikes) {

        return strikes == 3;
    }
}
