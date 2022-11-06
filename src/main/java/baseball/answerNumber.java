package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class answerNumber {
    public static List<Integer> makeAnswerNumber() {
        List<Integer> arrLst = new ArrayList<>();
        List<Integer> answerLst = new ArrayList<>();

        for(int i=1; i<10; i++) {
            arrLst.add(i);
        }
        Collections.shuffle(arrLst);
        for(int i=0; i<3; i++) {
            answerLst.add(i, arrLst.get(i));
        }
        System.out.println(answerLst);
        return answerLst;
    }
}
