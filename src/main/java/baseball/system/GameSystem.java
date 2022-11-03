package baseball.system;


import baseball.player.*;

public class GameSystem {

    public void runGame() {

        printRunGameText();

        for (; ; ) {

            startGame();

            if (!selectMenu()) {
                break;
            }

        }


    }

    private void startGame() {

        Computer computer = new Computer();
        User user = new User();

        GamePlay gamePlay = new GamePlay(computer,user);
        gamePlay.playGame();
        

    }



}
