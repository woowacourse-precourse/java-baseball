package baseball.service;

import baseball.vo.enumtype.GameRule;
import baseball.vo.enumtype.UserInterfaceMessage;
import baseball.vo.enumtype.ValidationMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperatorService {
    private List<Integer> playerGameNumberList;
    private OperatorService() {
    }

    private static class InnerOperatorService {
        private static final OperatorService instance = new OperatorService();
    }

    public static OperatorService getInstance() {
        return InnerOperatorService.instance;
    }

    public void printGameStartMessage() {
        System.out.println(UserInterfaceMessage.GAME_INFO.getValue());
    }

    public void validateGameNumber(String inputGameNumber) throws IllegalArgumentException {
        ValidationMessage validationMessage = validateUserInputCase(inputGameNumber);
        if (validationMessage != ValidationMessage.PROPER_TYPE) {
            System.out.println(validationMessage.getValue());
            throw new IllegalArgumentException(validationMessage.getValue());
        }
    }

    private ValidationMessage validateUserInputCase(String userInput) {
        if (userInput == null) return ValidationMessage.NULL_TYPE;
        if (userInput.isEmpty()) return ValidationMessage.EMPTY_TYPE;
        if (userInput.equals("0")) return ValidationMessage.ZERO_TYPE;
        if (userInput.length() < GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.UNDER_THREE;
        if (userInput.length() > GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.OVER_THREE;
        if (isDuplicateUserInput(userInput)) return ValidationMessage.NOT_DUPLICATE_NUMBER;
        try {
            Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            return ValidationMessage.NOT_NUMBER;
        }
        return ValidationMessage.PROPER_TYPE;
    }

    private boolean isDuplicateUserInput(String userInput) {
        String[] arrUserInput = userInput.split("");
        Set<String> userInputSet = new HashSet<>();
        for (String userInputNum : arrUserInput) {
            userInputSet.add(userInputNum);
        }
        return (arrUserInput.length != userInputSet.size());
    }
    public void operateGame(List<Integer> computerBaseballGameNumberList, String inputGameNumber) {
        playerGameNumberList = generateGameNumberList(inputGameNumber);

    }

    public List<Integer> generateGameNumberList(String playerInputGameNumber) {
        String[] arrPlayerInputGameNumber = playerInputGameNumber.split("");
        List<Integer> playerInputList = new ArrayList<>();
        for (String playerInputNum : arrPlayerInputGameNumber) {
            playerInputList.add(Integer.parseInt(playerInputNum));
        }
        return playerInputList;
    }

    public List<Integer> getPlayerGameNumberList() {
        return playerGameNumberList;
    }
}
