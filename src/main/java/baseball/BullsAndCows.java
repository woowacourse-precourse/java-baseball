package baseball;

public class BullsAndCows {

    private static String answer;

    public BullsAndCows() {
        playGame();
    }

    // 게임 전체 실행부
    public void playGame() throws IllegalArgumentException {
        startGame();
//        System.out.println("answer = " + answer);

        while (true) {
            String predictInput = getPredictInput(); // 사용자 입력

            if (isAnswer(predictInput)) {
                IO.alert_endGame();
                break;
            } else {
                printHint(predictInput);
            }
        }
    }

    private void startGame() {
        answer = Numbers.setAnswer();
        IO.alert_startGame();
    }

    private String getPredictInput() {
        String predictInput = IO.ask_predict();
        if (!Numbers.checkPredictInput_regex(predictInput) || !Numbers.checkPredictInput_duplicate(predictInput)) {
            throw new IllegalArgumentException();
        }
        return predictInput;
    }

    private boolean isAnswer(String predictInput) {
        return predictInput.compareTo(answer) == 0;
    }

    private void printHint(String predictInput) {
        int strike = 0;
        int ball = 0;
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

        // 힌트 출력
        IO.alert_hint(strike, ball, isNothing);
    }

}
