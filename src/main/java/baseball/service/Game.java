package baseball.service;

import baseball.controller.ReceiveConsole;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.PrintConsole;
import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    public Game(){
        computer = new Computer();
        user = new User(User.FIRST_PLAY);
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    public void gameStart(int userStatus) {
        switch (userStatus) {
            case User.FIRST_PLAY:
                printStartConsole();
            case User.RESTART_GAME:
                generateRandomNum();
            case User.RE_ANSWER:
                user.updateStatus(User.RE_ANSWER);
                receiveNumToUser();
                printResult();
                endGame();
                resetComputerUser();
                gameStart(user.getStatus());
            case User.END_GAME:
                break;
        }

    }
    private void printStartConsole() {
        PrintConsole.startGame();
    }

    private void generateRandomNum() {
        computer.generateRandomNumList();
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

    private void resetComputerUser() {
        if (user.getStatus() == User.FIRST_PLAY||user.getStatus() == User.RE_ANSWER) {
            resetForReAnswer();
        }else if(user.getStatus()==User.RESTART_GAME){
            resetForReStart();
        }
    }

    private void resetForReAnswer() {
        computer.resetCompareComponent();
        user = new User(User.RE_ANSWER);
    }

    private void resetForReStart(){
        computer = new Computer();
        user = new User(User.RESTART_GAME);
    }
}
