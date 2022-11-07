package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {

    private static String answer;
    public static final int ANSWER_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
     */
    public static void setAnswer() {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() != ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            String randomNumberToString = Integer.toString(randomNumber);

            if (stringBuilder.indexOf(randomNumberToString) == -1) {
                stringBuilder.append(randomNumberToString);
            }
        }
        answer = stringBuilder.toString();
    }

    /**
     * @param predictInput 사용자가 입력한 3자리 수
     * @return answer와 같을 시 true / 다를 경우 false
     */
    public static boolean isAnswer(String predictInput) {
        return predictInput.compareTo(answer) == 0;
    }

    /**
     * @param predictInput 사용자가 입력한 3자리 수
     */
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
