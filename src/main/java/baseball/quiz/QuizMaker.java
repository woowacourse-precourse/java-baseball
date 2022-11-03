package baseball.quiz;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class QuizMaker {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int LENGTH_OF_QUIZ = 3;

    public static List<Integer> NewQuiz() {
        List<Integer> quiz = new ArrayList<>();
        while (quiz.size() < LENGTH_OF_QUIZ) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!quiz.contains(randomNumber)) {
                quiz.add(randomNumber);
            }
        }

        return quiz;
    }
}
