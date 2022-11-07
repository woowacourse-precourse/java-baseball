package baseball;

import java.util.HashMap;

public class Game {
    public static final int NUMBER_LENGTH = 3;
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    public static MessagePrinter messagePrinter = new MessagePrinter();

    public boolean runningState = true;
    public Computer computer = new Computer();
    public User user = new User();

    public void run() {
        messagePrinter.printInit();
        while (runningState) {
            start(computer.makeRandomNumberString());
        }
    }

    private void start(String computerNumber) {
        while (true) {
            String userNumber = getUserNumber();
            HashMap<String, Integer> resultMap = compareTwoNumberStrings(computerNumber, userNumber);
            int ballCount = resultMap.getOrDefault(BALL, 0);
            int strikeCount = resultMap.getOrDefault(STRIKE, 0);
            messagePrinter.printResult(ballCount, strikeCount);
            if (checkAnswer(strikeCount)) {
                break;
            }
        }
        messagePrinter.printFinish();
        checkRestart();
    }

    private String getUserNumber() {
        messagePrinter.askInput();
        return user.getNewNumberString();
    }
}
