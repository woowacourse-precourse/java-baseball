package baseball.service;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.PrintConsole;

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


}
