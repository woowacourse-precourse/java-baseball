package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputMapping {
    public List<Integer> get(int inputNumber){
        return new ArrayList<>();
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
