package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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

    public static int disposeOfGameResult(int numberOfStrikes, int numberOfBalls) {
        if (numberOfBalls + numberOfStrikes == 0) {
            System.out.println("낫싱");
            return 1;
        }
        if (numberOfBalls == 0) {
            System.out.println(numberOfStrikes + "스트라이크");
            return 1;
        }
        if (numberOfStrikes == 0) {
            System.out.println(numberOfBalls + "볼");
            return 1;
        }
        if (numberOfStrikes == 3) {
            System.out.println("3스트라이크");
            return 0;
        }
        System.out.println(numberOfBalls + "볼 " + numberOfStrikes + "스트라이크");
        return 1;
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
}
