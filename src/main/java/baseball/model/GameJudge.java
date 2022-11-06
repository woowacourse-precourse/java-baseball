package baseball.model;


import java.util.ArrayList;
import java.util.List;

public class GameJudge {
    public String judgeGameResult(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i< playerNumber.size(); i++){
            if (isStrike(playerNumber.get(i), computerNumber.get(i))){
                strike++;
                continue;
            }
            if (isBall(playerNumber.get(i), computerNumber)){
                ball++;
            }
        }
        return changeResultMessage(strike, ball);
    }

    boolean isStrike(int player, int computer){
        if (player == computer){
            return true;
        }
        return false;
    }

    boolean isBall(int player, List<Integer> computerNumberList){
        for (Integer number : computerNumberList) {
            if (player == number) {
                return true;
            }
        }
        return false;
    }

    String changeResultMessage(int strike, int ball) {
        String result = "";
        if (ball > 0) {
            result = ball + "볼";
        }
        if (strike > 0) {
            if (!result.isEmpty()){
                result += " ";
            }
            result += strike + "스트라이크";
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }
        return result;
    }

//    public static void main(String[] args) {
//        ArrayList<Integer> player = new ArrayList<Integer>(List.of(1, 2, 3));
//        ArrayList<Integer> computer = new ArrayList<Integer>(List.of(7, 4, 8));
//        GameJudge judge = new GameJudge();
//        System.out.println(judge.judgeGameResult(player, computer));
//    }
}
/*
[_, _, _]
같은 자리, 같은 숫자 = S
같은 숫자 = B
모두 아님 = N

 */
