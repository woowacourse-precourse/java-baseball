package baseball;

import java.util.List;

public class StrikeBallNothingResultGenerator {
    static CompareComputerWithUser compare = new CompareComputerWithUser();

    public static String ResultJudgement(List<Integer> computerNumber, List<Integer> userNumber){
        int strike = compare.countStrike(computerNumber, userNumber);
        int ball = compare.countball(computerNumber, userNumber);
        int nothing = compare.nothing(computerNumber,userNumber);

        if (nothing == 3){
            return "낫싱";
        } else if (ball > 0 && ball < 3 && strike > 0 && strike < 3){
            return ball + "볼 " + strike + "스트라이크";
        } else if (ball == 0 && strike < 3){
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }

        return strike + "스트라이크";


    }

}
