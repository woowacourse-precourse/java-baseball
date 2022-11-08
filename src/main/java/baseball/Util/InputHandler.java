package baseball.Util;

import baseball.GameState;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    
    public static List<Integer> getUserInput() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return parseToIntegerList(userInput);
    }

    private static List<Integer> parseToIntegerList(String userInput){
        List<Integer> inputList = new ArrayList<>();
        for (String element:
             userInput.split("")) {
            inputList.add(Integer.parseInt(element));
        }
        return inputList;
    }

    public static GameState getRedoNumber(){
        String userInput = Console.readLine();
        int redo = InputValidator.validateRedo(userInput);
        if(redo == 1){
            return GameState.REDO;
        }
        else
            return GameState.SHUT_DOWN;
    }
}
