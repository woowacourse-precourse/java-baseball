package baseball;

import java.util.List;

public class Compare {

    public static int[] excutue(List<Integer> comNum, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int len = comNum.size(), i=0; i<len; i++){
            int play = userInput.charAt(i)-'0';

            if (comNum.indexOf(play) == -1){
                ball--;
            }
            if (comNum.indexOf(play) != i){
                ball++;
            }
            if (comNum.indexOf(play)==i){
                strike++;
            }
        }

        return new int[] { ball, strike };
    }

}
