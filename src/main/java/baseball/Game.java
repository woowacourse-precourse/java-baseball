package baseball;

public class Game {
    public static final int NUMBER_LENGTH = 3;
    public static MessagePrinter messagePrinter = new MessagePrinter();

    public boolean runningState = true;
    public Computer computer = new Computer();

    public void run() {
        messagePrinter.printInit();
        while (runningState) {
            start(computer.makeRandomNumberString());
        }
    }

    private void start(String computerNumber) {

    }
}
