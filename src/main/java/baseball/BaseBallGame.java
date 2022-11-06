package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame implements AutoCloseable {

    State currentState;
    protected List<Integer> answerNumber;

    public BaseBallGame(int hashcode){
        generateNumber(hashcode);
    }

    @Override
    public void close() throws Exception {

    }

    public void run() {

    }

    private void generateNumber(int randomSeed) {
        if(answerNumber == null){
            answerNumber = new ArrayList<>();
        }
        if(!answerNumber.isEmpty()){
            answerNumber.clear();
        }
        while( answerNumber.size() < 3){
            int randomNumber = (Randoms.pickNumberInRange(1, 9) + randomSeed % 10 ) % 9 + 1;
            if(!answerNumber.contains(randomNumber)){
                answerNumber.add(randomNumber);
            }
        }
    }

    private List<Integer> getUserINput() {
        return Collections.emptyList();
    }

    private boolean validateUserInput() {
        return false;
    }

    private List<Integer> getResultOfAnswer(List<Integer> challengeNumber) {
        return Collections.emptyList();
    }

    private void printResult(List<Integer> result) {
    }

    private enum State {

    }

    private enum Trigger {

    }


}
