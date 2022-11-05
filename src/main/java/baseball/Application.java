package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String correctAnswer = makeRandomNumStr();

        String userAnswer = Console.readLine();
        lengthCheck(userAnswer);

    }


    private static void lengthCheck(String userAnswer) {

        if (userAnswer.length()!=3){
            throw new IllegalArgumentException();
        }

    }



    private static String makeRandomNumStr() {
        Set<String> correctAnswer = new HashSet<>();

        while (correctAnswer.size() < 3) {
            String str = Randoms.pickNumberInRange(1, 9) + "";
            correctAnswer.add(str);
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (String s : correctAnswer
        ) {
            stringBuilder.append(s);
        }

        String randomNumStr = String.valueOf(stringBuilder);

        return randomNumStr;
    }

}
