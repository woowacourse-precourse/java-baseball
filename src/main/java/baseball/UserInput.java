package baseball;

import baseball.Util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput implements GameState{

    @Override
    public List<Integer> run() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return parseToIntegerList(userInput);
    }

    private List<Integer> parseToIntegerList(String userInput){
        List<Integer> inputList = new ArrayList<>();
        for (String element:
             userInput.split("")) {
            inputList.add(Integer.parseInt(element));
        }
        return inputList;
    }
}
