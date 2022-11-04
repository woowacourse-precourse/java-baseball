package baseball;

import java.util.Arrays;
import java.util.stream.Stream;

public class ScoreJudge {
    private CreateRandom random;
    private NumsInputFromUser input;

    public ScoreJudge() {
        this.random = new CreateRandom();
        this.input  = new NumsInputFromUser();
    }

    public String Judge() {
         int[] randomNums = random.makeRandomNums();
         int[] inputNums = input.getInputNumForGame();

         int strike  = 0;
         int ball    = 0;
         int nothing = 0;

         for (int i = 0; i < inputNums.length; i++) {
             int index = searchNumInArray(randomNums, inputNums[i]);
             if (index > -1 && i == index) {
                strike += 1;
             } else if (index > -1 && i != index) {
                 ball += 1;
             }
         }

         if (strike == 0 && ball == 0) nothing += 1;

         String result = resultString(strike, ball, nothing);

         return result;
    }

    public int searchNumInArray(int [] arr, int findNum) {
        for (int j = 0 ; j < 3; j++) {
            if (arr[j] == findNum) {
                return j;
            }
        }
        return -1;
    }

    public String resultString(int strike, int ball, int nothing) {
        if (nothing == 1) return "낫싱";

        String result = "";

        if (ball > 0) result += Integer.toString(ball) + "볼";
        if (strike >0) result += Integer.toString(strike) + "스트라이크";

        return result;
    }

}
