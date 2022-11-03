package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BullsAndCows {

    static final int ANSWER_LENGTH = 3;
    static String answer;

    public BullsAndCows() {
        playGame();
    }

    // 게임 전체 실행부
    public void playGame() {
        startGame();

        while (true) {
            String input = getInput(); // 사용자 입력
            if (isAnswer(input)) {
                // "3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                break;
            } else {
                printHint(input);
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

    private String getInput() {
        String input = "";
        // "숫자를 입력해주세요 : "
        return input;
    }

    private boolean isAnswer(String input) {
        boolean correct = false;
        // answer와 input을 비교
        return correct;
    }

    private void printHint(String input) {
        // 볼, 스트라이크, 낫싱
    }

}
