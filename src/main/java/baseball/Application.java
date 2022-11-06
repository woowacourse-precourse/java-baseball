package baseball;

import model.Computer;
import view.Print;

public class Application {

    public static void main(String[] args) {
        Print.gameStart();
        Computer computer = new Computer();
        computer.createDifferentRandomNumbers();
    }
}
