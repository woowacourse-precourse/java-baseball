package baseball;


import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        AnswerNumber answerNumber = new AnswerNumber();
        PlayerNumber playerNumber = new PlayerNumber();
        Output judge = new Output();
        TryAgain tryAgain = new TryAgain();
        boolean retry = true;

        while(retry) {
            ArrayList<Integer> answerNumList = answerNumber.getAnswerNumber();
            String result = "";
            while(!result.equals("3스트라이크")) {
                ArrayList<Integer> playerNumList = playerNumber.getPlayerNumber();
                result = judge.judgeResult(answerNumList, playerNumList);
                System.out.println(result);
            }
            if(result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            retry = tryAgain.tryAgainOrWhat(tryAgain.getRetryNum());
        }
    }
}
