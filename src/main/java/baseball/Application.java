package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        String correctAnswer = makeRandomNumStr();
        String correctAnswer = "123";
        String userAnswer = Console.readLine();

        lengthCheck(userAnswer);
        numberCheck(userAnswer);
        duplicateCheck(userAnswer);

        int strikeCount = getStrikeCount(correctAnswer, userAnswer);
        int ballCount = getBallCount(correctAnswer, userAnswer);
        System.out.println(strikeCount+" strike!");
        System.out.println(ballCount+" ball!");

    }
    private static int getBallCount(String correctAnswer, String userAnswer) {

        int ballCount = 0;

        for (int i = 0; i < correctAnswer.length(); i++) {

            char c = userAnswer.charAt(i);
            int findIndex = correctAnswer.indexOf(c);

            if (findIndex != i && findIndex >= 0) {
                ballCount++;
            }

        }
        return ballCount;
    }

    private static int getStrikeCount(String correctAnswer, String userAnswer) {

        int strikeCount = 0;

        for (int i = 0; i < correctAnswer.length(); i++) {

            char target = correctAnswer.charAt(i);

            if (target == userAnswer.charAt(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static void duplicateCheck(String userAnswer) {
        char first = userAnswer.charAt(0);
        char second = userAnswer.charAt(1);
        char third = userAnswer.charAt(2);

        if(first==second||second==third||first==third){
            throw new IllegalArgumentException();
        }
    }

    private static void numberCheck(String userAnswer) {
        for (int i = 0; i < userAnswer.length(); i++) {
            char c = userAnswer.charAt(i);
            int numericValue = Character.getNumericValue(c);

            if(numericValue<1||9<numericValue){
                throw new IllegalArgumentException();
            }

        }
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
