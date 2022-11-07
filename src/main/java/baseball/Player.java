package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    private List<Integer> userNumbers;
    Converter converter = new Converter();
    NumberValidator numberValidator = new NumberValidator();

    public List<Integer> getUserNumber() {
        return userNumbers;
    }

    public void inputPlayerNumber() {
        String inputNumbers = Console.readLine();
        this.userNumbers = converter.convertStringToListInteger(inputNumbers);
    }
}
