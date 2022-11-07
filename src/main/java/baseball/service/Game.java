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
        user = new User(User.FIRST_GAME);
    }

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    private void printStartConsole() {
        if (user.isFirst()==false) {
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


}
