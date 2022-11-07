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

    public static Integer countBall(List<Integer> answer, List<Integer> digitList) {

        int count = 0;

        for (int i = 0; i < digitList.size(); i++) {

            int digit = digitList.get(i);

            for (int j = 0; j < answer.size(); j++) {

                if (answer.get(j) == digit && i != j) {
                    count++;
                }

            }
        }

        return count;
    }

    public static Integer countStrike(List<Integer> answer, List<Integer> digitList) {

        int count = 0;

        for (int i = 0; i < digitList.size(); i++) {

            int digit = digitList.get(i);

            for (int j = 0; j < answer.size(); j++) {

                if (answer.get(j) == digit && i == j) {
                    count++;
                }

            }
        }

        return count;
    }
}
