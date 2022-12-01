package baseball;

import exceptions.ComputerNumbersException;

import java.util.List;

public class ComputerNumbers {
    private List<String> computerNumbers;

    public ComputerNumbers(List<String> computerNumbers) {
        ComputerNumbersException.validate(computerNumbers);
        System.out.println(computerNumbers);
        this.computerNumbers = computerNumbers;
    }

    public boolean isBall(String playerNumber) {
        return computerNumbers.contains(playerNumber);
    }

    public boolean isStrike(String playerNumber, int numberIndex) {
        return computerNumbers.get(numberIndex).equals(playerNumber);
    }
}
