package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BullsAndCows {

    static final int ANSWER_LENGTH = 3;
    static String answer;

    public BullsAndCows() {
        playGame();
    }

    // 게임 전체 실행부
    public void playGame() {
        startGame();
//        System.out.println("answer = " + answer);

        while (true) {
            String predictInput = getPredictInput(); // 사용자 입력
            if (!checkPredictInputRegex(predictInput)) {
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
        setAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void setAnswer() {
        List<Integer> randomNumberList = Randoms.pickUniqueNumbersInRange(1, 9, ANSWER_LENGTH); // 1 ~ 9까지 서로 다른 임의의 수 3개를 선택
        answer = randomNumberList.toString().replaceAll("[^0-9]", "");
    }

    private String getPredictInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private boolean checkPredictInputRegex(String predictInput) {
        String regex = "\\d{3}$"; // 3자리 숫자
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(predictInput);
        return matcher.matches();
    }

    private boolean isAnswer(String predictInput) {
        return predictInput.equals(answer);
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
