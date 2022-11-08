package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {
    private List<Integer> CorrectAnswer;

    public List<Integer> getAnswer(){
        return CorrectAnswer;
    }

    public void setAnswer(int first, int second, int third){
        CorrectAnswer.set(0, first);
        CorrectAnswer.set(1, second);
        CorrectAnswer.set(2, third);
    }

    public NumberBaseball(){ // generate answer by Randoms library
        CorrectAnswer = new ArrayList<Integer>();
        CorrectAnswer.add(Randoms.pickNumberInRange(0, 9));
        for(int i = 0; i < 2; i++){
            int temp;
            do{
                temp = Randoms.pickNumberInRange(0, 9);
            }
            while(CorrectAnswer.contains(temp));
            CorrectAnswer.add(temp);
        }
        //CorrectAnswer = Randoms.pickUniqueNumbersInRange(0,9,3);
    }



}
