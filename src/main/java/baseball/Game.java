package baseball;

public class Game {
    private ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();

    public void run() {
        System.out.println(computerRandomNumber.makeComputerNumber());
    }
}
