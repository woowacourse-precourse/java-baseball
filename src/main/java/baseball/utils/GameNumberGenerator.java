package baseball.utils;

import baseball.model.BaseNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.resources.GameConfig.*;

public class GameNumberGenerator {
    public static BaseNumber generate(){
        List<Integer> baseNumber = new ArrayList<>();
        while (baseNumber.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!baseNumber.contains(randomNumber)) {
                baseNumber.add(randomNumber);
            }
        }
        return new BaseNumber(baseNumber);
    }
}
