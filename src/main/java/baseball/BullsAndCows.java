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
            String input = getInput(); // 사용자 입력
            if (!checkInputRegex(input)) {
                throw new IllegalArgumentException();
            }

            if (isAnswer(input)) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private boolean checkInputRegex(String input) {
        String regex = "\\d{3}$"; // 3자리 숫자
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean isAnswer(String input) {
        return input.equals(answer);
    }

    private void printHint(String input) {
        // 볼, 스트라이크, 낫싱
    }

}
