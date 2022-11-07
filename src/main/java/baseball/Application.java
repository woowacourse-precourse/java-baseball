package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumber;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = getThreeRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = disposeOfInputNumber();
            int numberOfStrikes = getNumberOfStrikes(computerNumber, userNumber);
            int numberOfBalls = getNumberOfBalls(computerNumber, userNumber);
            String gameResult = disposeOfGameResult(numberOfStrikes, numberOfBalls);
            System.out.println(gameResult);

            if (determineStopOrNot(gameResult)) {
                break;
            }
        }
    }

    public static boolean determineStopOrNot(String gameResult) {
        if (!gameResult.equals("3스트라이크")) return false;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!isValidRestartNumber(input)) {
            throw new IllegalArgumentException();
        }
        int restartOrNot = Integer.parseInt(input);

        if (restartOrNot == 1) {
            computerNumber = getThreeRandomNumber();
            return false;
        }
        return true;
    }

    public static List<Integer> getThreeRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int tmpRandomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(tmpRandomNumber)) {
                randomNumbers.add(tmpRandomNumber);
            }
        }
        return randomNumbers;
    }

    public static List<Integer> disposeOfInputNumber() {
        String input = Console.readLine();
        if (!isValidBaseballNumber(input)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumbers = new ArrayList<>();

        for (char number : input.toCharArray()) {
            inputNumbers.add(number - '0');
        }

        return inputNumbers;
    }

    public static int getNumberOfStrikes(List<Integer> numberOfComputer, List<Integer> numberOfUser) {
        int numberOfStrikes = 0;

        for (int i = 0; i < 3; i++) {
            if (numberOfComputer.get(i) == numberOfUser.get(i)) {
                numberOfStrikes++;
            }
        }

        return numberOfStrikes;
    }

    public static int getNumberOfBalls(List<Integer> numberOfComputer, List<Integer> numberOfUser) {
        int numberOfBalls = 0;

        for (int i = 0; i < 3; i++) {
            if (numberOfComputer.get(i) == numberOfUser.get((i+1)%3)) {
                numberOfBalls++;
            }
            if (numberOfComputer.get(i) == numberOfUser.get((i+2)%3)) {
                numberOfBalls++;
            }
        }

        return numberOfBalls;
    }

    public static String disposeOfGameResult(int numberOfStrikes, int numberOfBalls) {
        if (numberOfBalls + numberOfStrikes == 0) {
            return "낫싱";
        }
        if (numberOfBalls == 0) {
            return numberOfStrikes + "스트라이크";
        }
        if (numberOfStrikes == 0) {
            return numberOfBalls + "볼";
        }
        if (numberOfStrikes == 3) {
            return "3스트라이크";
        }
        return numberOfBalls + "볼 " + numberOfStrikes + "스트라이크";
    }

    public static boolean isValidBaseballNumber(String input) {
        if (input.length() != 3) {
            return false;
        }

        List<Character> numberList = new ArrayList<>();
        for (char number : input.toCharArray()) {
            if (number > '9' || number < '1') {
                return false;
            }
            if (numberList.contains(number)) return false;

            numberList.add(number);
        }

        return true;
    }

    public static boolean isValidRestartNumber(String input) {
        return (input.equals("1") || input.equals("2"));
    }
}
