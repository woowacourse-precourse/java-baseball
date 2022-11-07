package baseball;

import baseball.computer.Computer;
import baseball.user.User;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        computer.setUser(user);

        computer.start();
        while (!computer.finished()) {
            Integer userInput = computer.getUserInput();
            computer.guessNumber(userInput);
        }
    }
}
