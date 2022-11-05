package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        answerNumber();
    }

    public static void answerNumber() {
        List<Integer> arrLst = new ArrayList<>();
        List<Integer> answerLst = new ArrayList<>();

        for(int i=1; i<10; i++) {
            arrLst.add(i);
        }
        Collections.shuffle(arrLst);
        for(int i=0; i<3; i++) {
            answerLst.add(i, arrLst.get(i));
        }
    }
}
