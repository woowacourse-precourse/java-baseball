package baseball.hint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hint {
    private static final int LENGTH_OF_QUIZ = 3;

    public static List<Integer> CompareTo(String quiz, String playerInput) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < LENGTH_OF_QUIZ; i++){
            int index = playerInput.indexOf(quiz.substring(i,i+1));
            if(index == i)
                strike++;
            else if(index != -1)
                ball++;
        }

        return Arrays.asList(strike, ball);
    }
}
