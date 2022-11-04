package baseball;

public class ScoreJudge {
    private NumsInputFromUser input;
    private int strike, ball, nothing;

    public ScoreJudge() {
        this.input  = new NumsInputFromUser();
    }

    public void Initializer() {
        strike   = 0;
        ball     = 0;
        nothing  = 0;
    }

    public String Judge(int[] randomNums) {
         int[] inputNums = input.getInputNumForGame();

         computeScore(inputNums, randomNums);

         if (strike == 0 && ball == 0) nothing += 1;

         String result = resultString();

         return result;
    }

    private void computeScore(int[] inputNums, int[] randomNums) {
        for (int i = 0; i < inputNums.length; i++) {
            int index = searchNumInArray(randomNums, inputNums[i]);
            strikeOrBall(i,index);
        }
    }

    private void strikeOrBall(int i , int index) {
        if (index > -1 && i == index) {
            strike += 1;
        } else if (index > -1 && i != index) {
            ball += 1;
        }
    }

    private int searchNumInArray(int [] arr, int findNum) {
        for (int j = 0 ; j < 3; j++) {
            if (arr[j] == findNum) {
                return j;
            }
        }
        return -1;
    }

    private String resultString() {
        if (this.nothing == 1) return "낫싱";

        String result = "";

        if (ball > 0) result += Integer.toString(ball) + "볼";
        if (strike > 0) {
            if (result.length() != 0) {
                result += " " + Integer.toString(strike) + "스트라이크";
            } else {
                result += Integer.toString(strike) + "스트라이크";
            }
        }

        return result;
    }
}
