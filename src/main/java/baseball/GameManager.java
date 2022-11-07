package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Rule;
import inputoutput.InputManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private InputManager inputManager = new InputManager();

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

}
