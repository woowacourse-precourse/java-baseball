package baseball;

import java.util.List;

public class Game {

    private int ball;
    private int strike;

    public void play() throws IllegalArgumentException{
        List<Integer> computerBallsList = Computer.makeBalls();
        List<Integer> userBallsList = User.inputBalls();
        compareComputerAndUser(computerBallsList,userBallsList);
    }

    private void compareComputerAndUser(List<Integer> computerBallsList, List<Integer> userBallsList) {
        for(int i=0; i<computerBallsList.size(); i++){
            if(userBallsList.contains(computerBallsList.get(i))){
                ball++;
            }
            if(computerBallsList.get(i)==userBallsList.get(i)){
                strike++;
            }
        }

        ball -= strike;
        /*System.out.println(computerBallsList.toString());
        System.out.println(userBallsList.toString());
        System.out.println("ball : "+ ball);
        System.out.println("strike : "+ strike);*/
    }
}
