package baseball;

import java.util.List;

public class core {
    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index){
        return computerNumber.get(index).equals(userNumber.get(index));
    }
}
