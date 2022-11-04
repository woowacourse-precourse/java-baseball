package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            String stringQuizNumber = getStringQuizNumber();
        }
    }

    public static String getStringQuizNumber() {
        List<Integer> quizEachNumList = new ArrayList<>();

        while (quizEachNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!quizEachNumList.contains(randomNumber)) {
                quizEachNumList.add(randomNumber);
            }
        }

        StringBuilder returnString = new StringBuilder();
        for (Integer integer : quizEachNumList) {
            returnString.append(integer);
        }

        return returnString.toString();
    }
}
