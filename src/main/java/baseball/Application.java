package baseball;

import domain.Computer;
import domain.Referee;
import domain.User;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Referee referee = new Referee(computer, user);

        playBaseballGame(user, referee, computer);
    }

    private static void playBaseballGame(User user, Referee referee, Computer computer) {
        computer.createRandomNumbers();
        user.guessComputerNumbers();
        referee.judge();
    }

}
