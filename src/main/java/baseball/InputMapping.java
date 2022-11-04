package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputMapping {
    public List<Integer> get(int inputNumber){
        if (nonValidateInput(inputNumber))
            throw new IllegalArgumentException("nonValidateInputNumber");
        List<Integer> getInputNumberList = new ArrayList<>();
        while (inputNumber > 0){
            getInputNumberList.add(inputNumber % 10);
            inputNumber /= 10;
        }
        return getInputNumberList;
    }

    private boolean nonValidateInput(int inputNumber){
        if (inputNumber < 111 || inputNumber > 999)
            return true;
        while (inputNumber > 0){
            if (inputNumber % 10 == 0)
                return true;
            inputNumber /= 10;
        }
        return false;
    }
}
