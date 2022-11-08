package baseball;

import baseball.User.Computer;
import baseball.User.Game;

public class Application {


    public static void main(String[] args) {
        Computer computer = new Computer();
        Game run = new Game();


        try {
            do {
                int[] answer = computer.RandomComputer();
                run.InputPlayerCheck(answer);
            } while (run.startGame());
        } catch (IllegalArgumentException e) {

        throw new IllegalArgumentException();
        }

    }


}
