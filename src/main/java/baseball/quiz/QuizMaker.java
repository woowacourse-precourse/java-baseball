package baseball.quiz;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class QuizMaker {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int LENGTH_OF_QUIZ = 3;

    public static String NewQuiz() {
        String quiz = "";
        while (quiz.length() < LENGTH_OF_QUIZ) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
            if (!quiz.contains(randomNumber)) {
                quiz += randomNumber;
            }
        }

        return quiz;
    }
}
