package baseball.hint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hint {
    private static final int LENGTH_OF_QUIZ = 3;
    private static final String MESSAGE_OF_NOTHING = "낫싱";
    private static final String MESSAGE_OF_STRIKE = "스트라이크";
    private static final String MESSAGE_OF_BALL = "볼";

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

    public static void Print(List<Integer> compareResult){
        String strike = Integer.toString(compareResult.get(0));
        String ball = Integer.toString(compareResult.get(1));

        if(!strike.equals("0")&&!ball.equals("0"))
            System.out.println(strike + MESSAGE_OF_STRIKE + " " + ball + MESSAGE_OF_BALL);
        else if(!ball.equals("0"))
            System.out.println(ball + MESSAGE_OF_BALL);
        else if(!strike.equals("0"))
            System.out.println(strike + MESSAGE_OF_STRIKE);
        else
            System.out.println(MESSAGE_OF_NOTHING);
    }
}
