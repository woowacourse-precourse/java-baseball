package baseball;

import java.util.List;

public class Game {
    public String play(){
        List<Integer> computerBallsList = Computer.makeBalls();
        List<Integer> userBallsList = User.inputBalls();
        return computerBallsList.toString();
    }
}
