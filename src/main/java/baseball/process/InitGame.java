package baseball.process;

import baseball.ui.OutputText;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InitGame {

    private final OutputText outputText;

    public InitGame(OutputText outputText){
        this.outputText = outputText;

        outputText.startGame();
    }

    public List<Integer> createComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }


}
