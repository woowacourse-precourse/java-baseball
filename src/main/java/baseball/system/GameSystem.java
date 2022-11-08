package baseball.system;

import baseball.player.*;
import baseball.system.constant.BaseballConstant;
import baseball.system.progress.GamePlay;
import baseball.system.progress.MenuSelection;

public class GameSystem {
    public void runGame() {
        printRunGameText();

        for (; ; ) {

            startGame();

            if (isQuit()) {
                break;
            }
        }

    }

    private void startGame() {
        Computer computer = new Computer();
        User user = new User();

        GamePlay gamePlay = new GamePlay(computer, user);
        gamePlay.playGame();
    }

    private int selectMenu() {
        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.startMenuSelection();
    }

    private boolean isQuit(){
       return selectMenu() == BaseballConstant.QUIT;
    }

    private void printRunGameText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
