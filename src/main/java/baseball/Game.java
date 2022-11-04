package baseball;

import java.util.*;

import static baseball.CompareNumber.compare;
import static baseball.Score.BALL;
import static baseball.Score.STRIKE;
import static baseball.Validation.isExistOnlyNumber;
import static baseball.Validation.isValidLength;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public static void play(List<String> computerNumber) {
        Map<Score, Integer> score = new HashMap<>(3);
        initializeScore(score);

        while (score.get(STRIKE) != 3) {
            List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
            if (!isValidLength(userInput) || !isExistOnlyNumber(userInput)) {
                throw new IllegalArgumentException();
            }

            compare(computerNumber, userInput, score);

            printResult(score);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
