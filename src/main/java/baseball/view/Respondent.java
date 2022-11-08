package baseball.view;

public class Respondent {
    public void respondScoreResult(int ball, int strike){
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
        if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }
        if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }
        if(ball != 0 && strike != 0){
            System.out.println(ball + "볼" + strike + "스트라이크");
        }
    }

    public static void respondGameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
