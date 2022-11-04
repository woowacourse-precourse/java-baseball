package baseball;

import Controller.game;
import domain.Computer;
import domain.User;

public class Application {
    public static void main(String[] args) {
        game.start();
        Computer computer=Computer.getInstance();
        User user= User.getInstance();
        computer.setNumber();

    }
}