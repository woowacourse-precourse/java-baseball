package controller;

import model.Computer;
import model.User;

public class GameController {

    User user;
    Computer computer;

    public GameController(User user, Computer computer) {
        this.user = new User();
        this.computer = new Computer();
    }

}
