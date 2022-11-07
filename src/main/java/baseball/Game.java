package baseball;

import java.util.HashMap;
import java.util.HashSet;

public class Game {
    public static final int NUMBER_LENGTH = 3;
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    public static final String GAME_STOP_RESPONSE = "2";
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

    private void checkRestart() {
        messagePrinter.askReplay();
        String response = user.getRestartResponse();
        updateRunningState(response);
    }

    private void updateRunningState(String response) {
        if (response.equals(GAME_STOP_RESPONSE)) {
            runningState = false;
        }
    }

    private static boolean checkAnswer(int strikeCount) {
        return strikeCount == NUMBER_LENGTH;
    }

    public HashMap<String, Integer> compareTwoNumberStrings(String computerNumber, String userNumber) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        HashSet<Character> computerNumberSet = addNumberStringToSet(computerNumber);
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (computerNumber.charAt(index) == userNumber.charAt(index)) {
                resultMap.put(STRIKE, resultMap.getOrDefault(STRIKE, 0) + 1);
                continue;
            }
            if (computerNumberSet.contains(userNumber.charAt(index))) {
                resultMap.put(BALL, resultMap.getOrDefault(BALL, 0) + 1);
            }
        }
        return resultMap;
    }

    private static HashSet<Character> addNumberStringToSet(String numberString) {
        HashSet<Character> computerNumberSet = new HashSet<>();
        for (int digit = 0; digit < NUMBER_LENGTH; digit++) {
            computerNumberSet.add(numberString.charAt(digit));
        }
        return computerNumberSet;
    }

    private String getUserNumber() {
        messagePrinter.askInput();
        return user.getNewNumberString();
    }
}
