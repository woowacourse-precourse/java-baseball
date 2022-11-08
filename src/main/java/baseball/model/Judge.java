package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    public static List<Integer> judge(List<Integer> quizNumber, List<Integer> userNumber) {
        int ball = 0;
        int strike = 0;
        for (int indexInUser = 0; indexInUser < 3; indexInUser++) {
            int indexInQuiz = quizNumber.indexOf(userNumber.get(indexInUser));
            if (indexInQuiz == indexInUser) {
                strike++;
            } else if (indexInQuiz > -1) {
                ball++;
            }
        }
        return List.of(ball, strike);
    }
}
