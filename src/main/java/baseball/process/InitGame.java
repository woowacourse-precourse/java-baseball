package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class InitGame {

    public List<Integer> createComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < Setting.INPUT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }


}
