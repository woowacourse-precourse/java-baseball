package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요. : ";
    private final static String INPUT_NEW_GAME_METHOD = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Hint hint;
    private final Exception exception;

    Game() {
        hint = new Hint();
        exception = new Exception();
    }

    Computer computer;
    Set<Integer> usingComputer;
    List<Integer> computerNumbers;

    private void initComputerInformation() {
        computer = new Computer();
        usingComputer = new HashSet<>();

        computerNumbers = computer.initRandomNumber();
        usingComputer.addAll(computerNumbers);
    }

    private List<Integer> inputUserNumber() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        String userInputNumber = Console.readLine();

        return isValidNumber(userInputNumber);
    }

    private int inputNextGameMode() {
        System.out.println(INPUT_NEW_GAME_METHOD);
        String method = Console.readLine();

        return isValidNextGameMode(method);
    }

    private int isValidNextGameMode(String method) {
        if (!exception.isValidNumber(method)) {
            throw new IllegalArgumentException();
        }

        int gameMode = Integer.parseInt(method);
        if (!exception.isValidGameMode(gameMode)) {
            throw new IllegalArgumentException();
        }

        return gameMode;
    }

    private int startGame() {
        while (true) {
            Integer inputNextGameMode = progressOfGame();
            if (inputNextGameMode != null) return inputNextGameMode;
        }
    }

    private Integer progressOfGame() {
        List<Integer> userNumbers = inputUserNumber();
        hint.getHint(computerNumbers, userNumbers, usingComputer);
        if (hint.isMatch(computerNumbers, userNumbers)) {
            return inputNextGameMode();
        }
        return null;
    }

    public void init() {
        while (true) {
            initComputerInformation();
            int nextGameMode = startGame();
            if (nextGameMode == 2) break;
        }
    }

    private List<Integer> setUserNumber(String userNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++) {
            userNumbers.add(Character.getNumericValue(userNumber.charAt(i)));
        }

        return userNumbers;
    }

    private List<Integer> isValidNumber(String userNumber) {
        if (!exception.isValidLength(userNumber)) {
            throw new IllegalArgumentException();
        }
        if (!exception.isValidNumber(userNumber)) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumbers = setUserNumber(userNumber);
        if (!exception.isValidDuplicate(userNumbers)) {
            throw new IllegalArgumentException();
        }

        return userNumbers;
    }
}
