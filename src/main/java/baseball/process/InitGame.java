package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class InitGame {

    private final OutputText outputText;
    private final Setting setting;

    public InitGame(OutputText outputText, Setting setting){
        this.outputText = outputText;
        this.setting = setting;

        outputText.startGame();
    }

    public List<Integer> createComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < setting.INPUT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }


}
