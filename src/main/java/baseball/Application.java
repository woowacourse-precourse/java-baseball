package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Number numFactory = new PlayerNum();
        Computer computer = new Computer();
        List<Integer> playerNumber;

        do{
            playerNumber = numFactory.createNumber();
            numFactory.verifyNumber(playerNumber);
            String gameStatus = computer.getResult(playerNumber);
            if(gameStatus == GameComment.RESTART){
                computer = new Computer();
            }else if (gameStatus == GameComment.TERMINATE) {
                break;
            }
            }while (true);
        }

}
