package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.CompareNumber.compare;
import static baseball.Score.BALL;
import static baseball.Score.STRIKE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<String> computerNumber = getComputerNumber();

        List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
        if (!isValidLength(userInput) || !isExistOnlyNumber(userInput)) {
            throw new IllegalArgumentException();
        }

        Map<Score, Integer> score = new HashMap<>(3);
        initializeScore(score);

        compare(computerNumber, userInput, score);

        printResult(score);
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }

    private static boolean isValidLength(List<String> userInput) {
        return userInput.size() == 3;
    }

    private static boolean isExistOnlyNumber(List<String> userInput) {
        boolean isOnlyNumber = false;

        for (String element : userInput) {
            isOnlyNumber = isOnlyNumber || Character.isDigit(element.charAt(0));
        }
        return isOnlyNumber;
    }

    private static void initializeScore(Map<Score, Integer> score) {
        for (Score name : Score.values()) {
            score.put(name, 0);
        }
    }

    private static void printResult(Map<Score, Integer> score) {
        int numberOfSTRIKE = score.get(STRIKE);
        int numberOfBALL = score.get(BALL);

        if (numberOfSTRIKE == 0 && numberOfBALL == 0) {
            System.out.println("낫싱");
            return;
        }

        if (numberOfBALL == 0) {
            System.out.println(numberOfSTRIKE + "스트라이크");
            return;
        }

        if (numberOfSTRIKE == 0) {
            System.out.println(numberOfBALL + "볼");
            return;
        }

        System.out.println(numberOfSTRIKE + "스트라이크 " + numberOfBALL + "볼");
    }
}
