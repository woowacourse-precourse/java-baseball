package baseball;

import java.util.List;

public class GameConsole {

    public static Integer strikeCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int len = 0; len < computerNumber.size(); len++) {
            if (computerNumber.get(len) == playerNumber.get(len)) {
                strike += 1;
            }
        }
        return strike;
    }

    public static Integer ballCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;
        for (int len = 0; len < computerNumber.size(); len++) {
            if (!(computerNumber.get(len) == playerNumber.get(len)) && computerNumber.contains(playerNumber.get(len))) {
                ball += 1;
            }
        }
        return ball;
    }
    /*
    public static String nothingCheck(List<Integer> computerNumber , List<Integer> playerNumber){
        String nothing = "";
        if(strikeCount(computerNumber,playerNumber) + ballCount(computerNumber,playerNumber) == 0){
            nothing += "낫싱";
        }
        return nothing;
    }
    */
}
