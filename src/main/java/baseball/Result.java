package baseball;

import java.util.List;

public class Result {
    public static int checkStrike(int computer, int input, int strike){
        if(computer == input){
            strike++;
        }
        return strike;
    }
    public static int checkBall(List<Integer> computer, int input, int index, int ball){
        if(computer.contains(input) && (computer.indexOf(input) != index)){
            ball++;
        }
        return ball;
    }
    public static void printResult(int ball, int strike){
        String result;
        if(ball != 0 && strike != 0){
            result = ball+"볼 "+strike+"스트라이크";
        }else if(ball!=0 && strike == 0) {
            result = ball + "볼";
        }else if(ball == 0 && strike != 0){
            result = strike+"스트라이크";
        }else{
            result = "낫싱";
        }
        System.out.println(result);
    }
}
