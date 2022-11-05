package baseball;

import java.util.List;

public class Game {
    public String play(){
        try{
            List<Integer> computerBallsList = Computer.makeBalls();
            List<Integer> userBallsList = User.inputBalls();
        } catch (IllegalArgumentException e){
            System.out.println( e.getMessage());
        }
        return null;
    }
}
