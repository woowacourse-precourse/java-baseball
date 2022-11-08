package baseball;

import java.util.*;

import static baseball.Application.NUMBER_OF_DIGIT;
import static baseball.CompareNumber.compare;
import static baseball.Score.BALL;
import static baseball.Score.STRIKE;
import static baseball.Validation.hasOnlyNumber;
import static baseball.Validation.isValidLength;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static final int NUMBER_OF_SCORE = 2;

    public static void play(List<String> computerNumber) {
        boolean isFinished = false;
        Map<Score, Integer> score;

        while (!isFinished) {
            score = new HashMap<>(NUMBER_OF_SCORE);
            initScore(score);

            System.out.print("숫자를 입력해주세요 : ");

            List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
            if (!isValidLength(userInput, NUMBER_OF_DIGIT) || !hasOnlyNumber(userInput)) {
                throw new IllegalArgumentException();
            }

            compare(computerNumber, userInput, score);

            printResult(score);
            isFinished = score.get(STRIKE) == 3;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void initScore(Map<Score, Integer> score) {
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

        System.out.println(numberOfBALL + "볼 " + numberOfSTRIKE + "스트라이크 ");
    }
}
