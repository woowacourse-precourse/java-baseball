package baseball.view;

public class GameOutput {
    public static void scoreMessage(int BallNum, int StrikeNum){
        if (BallNum>0 && StrikeNum>0){
            System.out.println(BallNum+"볼"+" "+StrikeNum+"스트라이크");
        }
        if (BallNum==0 && StrikeNum!=0){
            System.out.println(StrikeNum+"스트라이크");
        }
        if (BallNum!=0 && StrikeNum==0){
            System.out.println(BallNum+"볼");
        }
        if (BallNum==0 && StrikeNum==0){
            System.out.println("낫싱");
        }
    }

    public static void finishGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
