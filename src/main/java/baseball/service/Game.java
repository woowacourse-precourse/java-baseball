package baseball.service;

import baseball.model.Computer;
import baseball.model.User;

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
}
