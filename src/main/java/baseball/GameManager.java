package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Rule;
import constants.Text;
import inputoutput.InputManager;
import inputoutput.OutputManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManager {
    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private InputManager inputManager;
    private Umpire umpire;
    private String playerChoice;

    public GameManager() {
        inputManager = new InputManager();
        umpire = new Umpire();
        playerChoice = "";
    }

    private void generateComputerNumber() {
        computerNumber = new ArrayList<>();
        Rule number = Rule.NUMBER;

        while (computerNumber.size() != number.getLength()) {
            int randomNumber = Randoms.pickNumberInRange(number.getMin(), number.getMax());

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }

        }
    }

    private void setPlayerNumber() {
        String number = inputManager.getPlayerNumber();

        playerNumber = Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void reportHint() {
        Map<Text, Integer> hintRecord = umpire.compareNumber(computerNumber, playerNumber);
        OutputManager.printHint(hintRecord);
    }

    private void playOneRound() {
        setPlayerNumber();
        reportHint();
    }

    private void isPlayEnd() {
        if (umpire.isPlayerWin()) {
            OutputManager.notifyEnd();
            playerChoice = inputManager.getPlayerChoice();
            resetGame();
        }
    }

    public void startPlay() {
        generateComputerNumber();

        while (!playerChoice.equals(Text.END.toString())) {
            playOneRound();
            isPlayEnd();
        }

    }

    private void resetGame() {
        if (playerChoice.equals(Text.RESTART.toString())) {
            generateComputerNumber();
            playerChoice = "";
        }
    }

}
