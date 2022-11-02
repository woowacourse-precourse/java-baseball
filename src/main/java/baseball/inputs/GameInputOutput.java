package baseball.inputs;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameInputOutput {
    public List<Integer> computerMadeNumbers(){
        List<Integer> numberMadeByComputer = new ArrayList<>();
        while(numberMadeByComputer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numberMadeByComputer.contains(randomNumber)){
                numberMadeByComputer.add(randomNumber);
            }
        }

        return numberMadeByComputer;
    }
}
