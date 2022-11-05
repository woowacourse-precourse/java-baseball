package baseball;

import baseball.computer.Computer;
import baseball.user.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        User user = new User();

        computer.start();
        while (!computer.finished()) {
            Integer userInput = computer.getUserInput(user);
            computer.guessNumber(userInput);
        }
    }
}
