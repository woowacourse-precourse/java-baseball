package controller;

import baseball.BaseballException;
import model.Computer;
import model.PlayerRepository;
import view.Player;

public class BaseballGame {

    public static void startGame() {
        PlayerRepository playerRepository = new PlayerRepository();
        Computer computer = new Computer();
        boolean checkExit = false;
        String playerNumber;

        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }

        Player.startPhrase();
        System.out.println(computer.getComputerNumber());

        while (!checkExit) {
            playerNumber = Player.numberInput();
            checkException(playerNumber);

            playerRepository.setPlayerNumber(playerNumber);
            checkExit = isCorrect(playerRepository, computer);
            hintPrint(playerRepository, computer, checkExit);
        }

        Player.printEnd();
        if (Player.endGame()) {
            startGame();
        }

    }

    public static boolean isCorrect(PlayerRepository playerRepository, Computer computer) {
        int userInput;
        int computerNumber;

        userInput = Integer.parseInt(playerRepository.getPlayerNumber());

        computerNumber = computer.getComputerNumber();

        return userInput == computerNumber;
    }

    public static void checkException(String playerNumber) {
        try {
            BaseballException.InputLengthException(playerNumber);
            BaseballException.InputTypeBoundaryException(playerNumber);
            BaseballException.InputRepeatException(playerNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            throw new IllegalArgumentException();
        }

    }

    public static void hintPrint(PlayerRepository playerRepository, Computer computer, boolean isRight) {
        int ball = 0;
        int strike = 0;
        int index = 0;
        String computerNumber;

        if (isRight) {
            return;
        }

        computerNumber = Integer.toString(computer.getComputerNumber());

        for (char playerChar : playerRepository.getPlayerNumber().toCharArray()) {
            ball += countBall(playerChar, computerNumber, index);
            strike += countStrike(playerChar, computerNumber, index);
            index += 1;
        }

        Player.printHint(ball, strike);
    }

    public static int countBall(char playerChar, String computerNumber, int playerIndex) {
        char[] computerCharArray = computerNumber.toCharArray();
        int i;

        for (i = 0; i < computerCharArray.length; i++) {
            if (i == playerIndex) {
                continue;
            }

            if (playerChar == computerCharArray[i]) {
                return 1;
            }
        }

        return 0;
    }

    public static int countStrike(char playerChar, String computerNumber, int playerIndex) {
        if (playerChar == computerNumber.charAt(playerIndex)) {
            return 1;
        }

        return 0;
    }
}
