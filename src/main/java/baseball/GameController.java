package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class GameController {
    Computer computer = new Computer();
    Exception exception = new Exception();
    String randomNumber;
    final int replay = 1;
    final int end = 2;

    public void start() {
        Message.start();
        setRandomNumber();
        playing();
    }

    private void setRandomNumber() {
        randomNumber = computer.createRandomNumber();
    }

    private void playing() {
        String userNumber = getUserNumber();
        String hint = hint(userNumber, randomNumber);

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

    public String hint(String userNumber, String randomNumber) {
        HashMap<String, Integer> hint = computer.getHint(userNumber, randomNumber);

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

        if (checkReplay == replay) {
            start();
        } else if (checkReplay == end) {
            return;
        }
    }
}