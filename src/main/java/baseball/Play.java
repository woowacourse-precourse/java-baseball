package baseball;
import java.util.List;
import java.util.ArrayList;

public class Play {
    public static void playGame(List<Integer> computer){
        int strikeCounter = 0;

        do{
            ArrayList<Integer> user = Settings.userNumber();
            strikeCounter = Game.strike(user, computer);
            int ballCounter = Game.ball(user, computer);
            boolean nothingTrue = Game.nothing(strikeCounter, ballCounter);

            printResult(ballCounter, strikeCounter, nothingTrue);

        } while(strikeCounter != 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(int ballCounter, int strikeCounter, boolean nothingTrue){
        if(ballCounter!=0 && strikeCounter!=0) {
            System.out.println(ballCounter+"볼 "+ strikeCounter+"스트라이크");
        }
        if(ballCounter==0 && strikeCounter!=0) {
            System.out.println(strikeCounter+"스트라이크");
        }
        if(ballCounter!=0 && strikeCounter==0) {
            System.out.println(ballCounter+"볼");
        }
        if(nothingTrue) System.out.println("낫싱");
    }

}
