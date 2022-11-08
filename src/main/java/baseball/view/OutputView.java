package baseball.view;

public class OutputView {
    public static String gameResult(int ball, int strike){
        if(strike + ball == 0){
            return "낫싱";
        }

        if(strike == 0){
            return ball + "볼";
        }

        if(ball == 0){
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
