package baseball;

import java.util.List;
import java.util.Set;

public class Playing {
    public static int numConfirm(int strikeCount, int ballCount, int playNum, int computerNum){
        if(playNum == computerNum){
            return ++strikeCount;
        } else {
            return ++ballCount;
        }
    }
    public static void compare(List<Integer> playerNum, List<Integer> computerNum){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i < computerNum.size(); i++){
            if(computerNum.contains(playerNum.get(i))){
                numConfirm(strikeCount, ballCount, playerNum.get(i), computerNum.get(i));
            }
        }
        result(strikeCount, ballCount, playerNum, computerNum);
    }
    public static void result(int strikeCount, int ballCount, List<Integer> playerNum, List<Integer> computer){
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
            SetPlay.run(playerNum, computer);
        } else if(strikeCount == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            Retry.printSentence();
        } else{
            System.out.println(ballCount + "볼 "+strikeCount+"스트라이크");
            SetPlay.run(playerNum, computer);
        }
    }
}
