package baseball;

import java.util.List;

public class Game {
    public String play(){
        List<Integer> computerBallsList = Computer.makeBalls();
        // System.out.println(computerBalls.toString());
        return computerBallsList.toString();
    }
}
