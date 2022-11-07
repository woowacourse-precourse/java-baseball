package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GameController {
    Computer computer = new Computer();
    Exception exception = new Exception();
    String goalNumber;

    public void start() {
        Message.start();
        setGoalNumber();
        playing();
    }

    private void setGoalNumber() {
        goalNumber = computer.createRandomNumber();
    }

    private void playing() {
        String userNumber = getUserNumber();
        String hint = hint(userNumber, goalNumber);

        gameResult(hint);
    }

    private String getUserNumber() throws IllegalArgumentException {
        Message.getUserNumber();
        String userNumber = Console.readLine();

        if (!exception.isCheckDigit(userNumber)
                || !exception.isCheckLength(userNumber)
                || !exception.isCheckOverlap(userNumber)
                || !exception.isCheckRange(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public String hint(String userNumber, String goalNumber) {
        HashMap<String, Integer> hint = computer.getHint(userNumber, goalNumber);

        if (hint.get("strike") == 0 && hint.get("ball") == 0) {
            return "낫싱";
        } else if (hint.get("strike") == 3) {
            return hint.get("strike") + "스트라이크";
        } else if (hint.get("ball") == 0) {
            return hint.get("strike") + "스트라이크";
        } else if (hint.get("strike") == 0) {
            return hint.get("ball") + "볼";
        } else {
            return hint.get("ball") + "볼" + " " + hint.get("strike") + "스트라이크" + " ";
        }
    }

    private void gameResult(String hint) {
        if (hint.equals("3스트라이크")) {
            endGame();
        } else if (hint.contains("nothing")) {
            Message.nothing();
            playing();
        } else {
            Message.hint(hint);
            playing();
        }
    }

    private void endGame() {
        Message.endGame();
        Message.replay();

        int checkReplay = Integer.parseInt(Console.readLine());

        if (!exception.isValidNumber(checkReplay)) {
            throw new IllegalArgumentException();
        }

        if (checkReplay == 1) {
            start();
        } else if (checkReplay == 2) {
            return;
        }
    }

    private List<Integer> changeList(String inputNumber) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char temp = inputNumber.charAt(i);
            list.add(i);
        }
        return list;
    }
}