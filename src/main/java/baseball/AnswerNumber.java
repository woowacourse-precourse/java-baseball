package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class AnswerNumber {
    private String answerNumber;
    private List<String> saveAnswerNumber;

    public AnswerNumber(){
        this. answerNumber= "";
        saveAnswerNumber = new ArrayList<>();
    }

    public void RandomNumber(){
            String [] number = new String[3];
            StringBuffer numbers = new StringBuffer();
            for(int i=0; i<number.length; i++){
                String num = String.valueOf(pickNumberInRange(1,9));
                if(!num.equals(number[i])) {
                    number[i] = num;
                    numbers.append(num);
                }
            }
            answerNumber =  numbers.toString();
    }
}
