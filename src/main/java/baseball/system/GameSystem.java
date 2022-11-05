package baseball.system;

import baseball.player.*;

public class GameSystem {


    private Computer computer;
    private User user;
    private MenuSelection menuSelection;

    private GamePlay gamePlay;

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

         computer = new Computer();
         user = new User();

         gamePlay = new GamePlay(computer,user);
         gamePlay.playGame();


    }

    private boolean selectMenu() {

        menuSelection = new MenuSelection();
        return menuSelection.startMenuSelection();

    }

    private void printRunGameText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


}
