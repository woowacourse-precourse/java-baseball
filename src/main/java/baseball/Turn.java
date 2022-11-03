package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Turn {
    private static final int NUMBER_OF_INPUT_DIGITS= 3;
    private static final String ASK_FOR_NUMBER = "숫자를 입력해주세요 : ";
    private List<Integer> playerNumberList;
    private int numberOfBalls;
    private int numberOfStrikes;

    public Turn() {
        this.playerNumberList = new ArrayList<>();
        numberOfBalls = 0;
        numberOfStrikes = 0;
    }

    public void transformPlayerInputToList() {
        String playerInput = getPlayerInput();
        for (int index = 0; index < playerInput.length(); index++) {
            playerNumberList.add(playerInput.charAt(index) - '0');
        }
    }

    public String getPlayerInput() {
        System.out.print(ASK_FOR_NUMBER);
        return Console.readLine();
    }

    public void validatePlayerNumberList(){
        if (playerNumberList.size() != NUMBER_OF_INPUT_DIGITS) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
        for (int number : playerNumberList) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }
        }
        Set<Integer> numberSet = new HashSet<>(playerNumberList);
        if (numberSet.size() < playerNumberList.size()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해주세요.");
        }
    }

    public void countNumberOfStrikes(List<Integer> hiddenNumberList){
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = this.playerNumberList.get(index);
            if (hiddenNumber == playerNumber) {
                this.numberOfStrikes++;
            }
        }
    }

    public void countNumberOfBalls(List<Integer> hiddenNumberList){
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = this.playerNumberList.get(index);
            if (hiddenNumberList.contains(playerNumber) && hiddenNumber != playerNumber) {
                this.numberOfBalls++;
            }
        }
    }
}
