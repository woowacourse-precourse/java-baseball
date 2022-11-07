package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BullsAndCows {

    private static String answer;

    public BullsAndCows() {
        playGame();
    }

    // 게임 전체 실행부
    public void playGame() {
        startGame();
//        System.out.println("answer = " + answer);

        while (true) {
            String predictInput = getPredictInput(); // 사용자 입력
            if (!Numbers.checkPredictInput_regex(predictInput) || !Numbers.checkPredictInput_duplicate(predictInput)) {
                throw new IllegalArgumentException();
            }

            if (isAnswer(predictInput)) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else {
                printHint(predictInput);
            }
        }
    }

    private void startGame() {
        answer = Numbers.setAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private String getPredictInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
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

        // 출력
        if (isNothing) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

}
