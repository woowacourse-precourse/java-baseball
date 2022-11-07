package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> createInputNumberList(String input) {
        ValidationCode.validateAnswer(input);

        List<Integer> inputList = new ArrayList<>();
        for (String number : input.split("")){
            inputList.add(Integer.parseInt(number));
        }
        return inputList;
    }
}
