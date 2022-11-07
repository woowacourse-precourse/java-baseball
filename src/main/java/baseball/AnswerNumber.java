package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class AnswerNumber {
    private List<String> answerNumber;
    private List<String> saveAnswerNumber = new ArrayList<>();

    public AnswerNumber(){
        answerNumber = new ArrayList<>();
    }

    public List<String> saveAnswerNumber(){
        return saveAnswerNumber;
    }

    public void RandomNumber(){
            String [] number = new String[3];
            for(int i=0; i<number.length; i++){
                String num = String.valueOf(pickNumberInRange(1,9));
                if(!num.equals(number[i])) {
                    number[i] = num;
                    answerNumber.add(num);
                }
            }
            saveAnswerNumber.add(answerNumber.toString());
    }
}
