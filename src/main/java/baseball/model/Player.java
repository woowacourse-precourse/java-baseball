package baseball.model;

import baseball.Converter;
import baseball.GameStatus;
import baseball.NumberValidator;
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
        System.out.print(GameStatus.INPUT.message());
        String inputNumbers = Console.readLine();

        numberValidator.validateInput(inputNumbers);
        this.userNumbers = converter.convertStringToListInteger(inputNumbers);
    }
}
