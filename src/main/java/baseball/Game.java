package baseball;

import java.util.List;

public class Game {
    public String play(){
        List<Integer> computerBalls = Computer.makeBalls();
        // System.out.println(computerBalls.toString());
        return computerBalls.toString();
    }
}
