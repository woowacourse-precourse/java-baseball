package baseball.game;

import static baseball.Application.CONTINUE_GAME;
import static baseball.Application.STOP_GAME;
import static baseball.game.Computer.COMPUTER_NUMBER_SIZE;

import baseball.message.SystemMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> inputPlayerNumber() {
        System.out.print(SystemMessage.ENTER_NUMBER);
        String playerNumber = Console.readLine();

        if (playerNumber.length() != COMPUTER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        if (playerNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        for (int i=0; i< playerNumber.length(); i++) {
            char letter = playerNumber.charAt(i);
            if (Character.getNumericValue(letter) < 1 || Character.getNumericValue(letter) > 9) {
                throw new IllegalArgumentException();
            }
        }

        return stringToList(playerNumber);
    }

    public String inputContinueOrStop() {
        System.out.println(SystemMessage.START_NEW_GAME_OR_END);
        String continueOrStop = Console.readLine();

        if (!continueOrStop.equals(Integer.toString(CONTINUE_GAME))
                && !continueOrStop.equals(Integer.toString(STOP_GAME))) {
            throw new IllegalArgumentException();
        }

        return continueOrStop;
    }

    private List<Integer> stringToList(String playerInput) {
        List<Integer> playerNumber = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            char current = playerInput.charAt(i);
            playerNumber.add(Character.getNumericValue(current));
        }
        return playerNumber;
    }
}
