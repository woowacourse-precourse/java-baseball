package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GameController {
    String goalNumber;

    public void start() {
        Message.start();
        setGoalNumber();
        playing();
    }

    private void setGoalNumber() {
        goalNumber = Computer.createRandomNumber();
    }

    private void playing() {
        String userNumber = getUserNumber();
        String hint = hint(userNumber, goalNumber);

        gameResult(hint);
    }

    public void gameResult(String hint) {
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

    public void endGame() {
        Message.endGame();
        Message.replay();

        int checkReplay = Integer.parseInt(Console.readLine());

        if (!Exception.isValidNumber(checkReplay)) {
            throw new IllegalArgumentException();
        }

        if (checkReplay == 1) {
            start();
        } else if (checkReplay == 2) {
            return;
        }
    }

    public static String hint(String userNumber, String goalNumber) {
        HashMap<String, Integer> hint = Computer.getHint(userNumber, goalNumber);

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

    public String getUserNumber() throws IllegalArgumentException {
        Message.getUserNumber();
        String userNumber = Console.readLine();

        if (!Exception.isCheckDigit(userNumber)
                || !Exception.isCheckLength(userNumber)
                || !Exception.isCheckOverlap(userNumber)
                || !Exception.isCheckRange(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
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