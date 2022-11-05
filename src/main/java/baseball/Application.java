package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class GameReadyMachine {
    private int answerValue;

    public boolean setAnswerValue (){
        answerValue = Randoms.pickNumberInRange(100,999);
        if(answerValue>=100||answerValue<=999)
            return true;
        else
            return false;
    }
}
public class Application {
    public static void main(String[] args) {

    }
}
