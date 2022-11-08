package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class answerNumber {
    public static List<Integer> makeAnswerNumber() {
//        List<Integer> arrLst = new ArrayList<>();
//        List<Integer> answerLst = new ArrayList<>();

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        System.out.println(computer);



//        for(int i=1; i<10; i++) {
//            arrLst.add(i);
//        }
//        Collections.shuffle(arrLst);
//        for(int i=0; i<3; i++) {
//            answerLst.add(i, arrLst.get(i));
//        }
        return computer;
    }
}
