package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberManager {

    private static String answer;
    public static final int ANSWER_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static void setAnswer() {
        List<Integer> randomNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, ANSWER_LENGTH); // 1 ~ 9까지 서로 다른 임의의 수 3개를 선택
        answer = randomNumberList.toString().replaceAll("[^1-9]", "");
//        System.out.println("answer = " + answer);
    }

    public static boolean isAnswer(String predictInput) {
        return predictInput.compareTo(answer) == 0;
    }

    public static void getHint(String predictInput) {
        int ball = 0;
        int strike = 0;
        boolean isNothing = false;

        // 스트라이크 & 볼의 개수 세기
        for (int i = 0; i < predictInput.length(); i++) {
            char number = predictInput.charAt(i);
            int answerIdxOfNumber = answer.indexOf(number);

            if (answerIdxOfNumber == i) {
                strike++;
            } else if (answerIdxOfNumber != -1) {
                ball++;
            }
        }

        // 스트라이크와 볼의 개수가 전부 0이라면 낫싱
        if (strike == 0 && ball == 0) {
            isNothing = true;
        }

        GameManager.ball = ball;
        GameManager.strike = strike;
        GameManager.isNothing = isNothing;
    }

}
