package baseball;

public class ScoreJudge {
    private NumsInputFromUser input;
    private int strike;
    private int ball;
    private int nothing;

    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE  = "스트라이크";
    private static final String BALL_MESSAGE    = "볼";

    public ScoreJudge() {
        this.input  = new NumsInputFromUser();
    }

    public void initializer() {
        strike   = 0;
        ball     = 0;
        nothing  = 0;
    }

    public String judge(int[] randomNums) {
         int[] inputNums = input.getInputNumForGame();

         computeScore(inputNums, randomNums);

         if (strike == 0 && ball == 0) nothing += 1;

         return resultString();
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
        if (this.nothing == 1) return NOTHING_MESSAGE;

        String result = "";

        if (ball > 0) result += ball + BALL_MESSAGE;
        if (strike > 0) {
            if (result.length() != 0) {
                result += " " + strike + STRIKE_MESSAGE;
            } else {
                result += strike + STRIKE_MESSAGE;
            }
        }

        return result;
    }
}
