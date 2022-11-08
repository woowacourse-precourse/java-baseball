package baseball.model;

import baseball.validator.PlayerInputValidator;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    private List<Integer> playerNum = new ArrayList<>();

    public void setPlayerNumber() {
        String playerInput = InputView.inputNumberMessage();

        PlayerInputValidator.inputValidate(playerInput);
        this.playerNum = parseNumber(playerInput);
    }

    public List<Integer> getPlayerNum() {
        setPlayerNumber();
        return playerNum;
    }

    public List<Integer> parseNumber(String playerInput) {
        List<Integer> integerList = new ArrayList<>();

        for (char ch : playerInput.toCharArray()) {
            integerList.add(Character.digit(ch, 10));
        }
        return integerList;
    }
}
