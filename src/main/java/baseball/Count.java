package baseball;

import java.util.List;

public class Count {

    public static void showCount(List<Integer> countList) {   // Index ( 0 : BALL / 1 : STRIKE )

        int ball, strike;
        ball = countList.get(0);
        strike = countList.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(strike + "스트라이크");
        }

    }

    public static List<Integer> calculateCount(List<Integer> answerList, List<Integer> digitList) { // Index ( 0 : BALL / 1 : STRIKE )

        int ball = 0, strike = 0;

        for (int i = 0; i < digitList.size(); i++) {

            int answer = answerList.get(i);
            int digit = digitList.get(i);

            if (answer == digit) {
                strike += 1;
            } else if (answerList.contains(digit)) {
                ball += 1;
            }

        }

        List<Integer> count = List.of(ball, strike);

        return count;
    }

}
