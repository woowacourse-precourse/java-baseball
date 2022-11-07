package baseball.service;

import baseball.controller.ReceiveConsole;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.PrintConsole;
import java.util.List;

public class Game {
    private static final boolean USER_FIRST_GAME=true;
    private static final boolean USER_RESTART_GAME=false;

    private Computer computer;
    private User user;

    public Game(){
        computer = new Computer();
        user = new User(USER_FIRST_GAME);
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    private void printStartConsole() {
        if (user.isFirstGame()) {
            PrintConsole.startGame();
        }
    }

    private void generateRandomNum() {
        computer.getRandomNum();
    }

    private void receiveNumToUser() {
        PrintConsole.receiveNum();
        List<Integer> usersNumList = ReceiveConsole.receiveNumIncludeAllException();
        user.updateNumList(usersNumList);
    }

    private void printResult() {
        computer.compareUsersNum(user.getNumList());
        PrintConsole.printResult(computer);
    }

    private void choiceRestartOrEnd(){
        int usersStatus = ReceiveConsole.choiceGameContinue();
        user.updateStatus(usersStatus);
    }

    private void endGame() {
        if (computer.isThreeStrike()) {
            PrintConsole.endGame();
            choiceRestartOrEnd();
        }
    }

    private void computerResetForPlaying() {
        computer.resetCompareComponent();
    }

    private void computerAndUserResetForRestart(){
        computer = new Computer();
        user = new User(USER_RESTART_GAME);

    }


//    public void switchGameToUsersAnswer(){
//        switch (user.getStatus()) {
//            case User.PLAYING:
//                computerReset();
//                break;
//            case User.RESTART_GAME:
//                resetForRestartGame();
//                Start();
//                Play();
//                break;
//            case END_GAME:
//                return;
//        }
//    }


}
