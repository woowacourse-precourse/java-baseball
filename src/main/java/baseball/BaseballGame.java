package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGame {

    public void play() {
        printStartMessage();
        while (true) {
            String answer = generateAnswer();
            playRound(answer);
            boolean doReplay = selectIfReplay();
            if (!doReplay) {
                break;
            }
        }
    }

    public void playRound(String answer) {
        while (true) {
            printInputMessage();
            String userInput = getUserInput();
            validateNumberInput(userInput);
            Map<String, Integer> score = gradeScore(answer, userInput);
            printScore(score.get("strike"), score.get("ball"));
            if (score.get("strike") == 3) {
                break;
            }
        }
    }

    public boolean selectIfReplay() {
        printEndMessage();
        String userInput = getUserInput();
        validateIfReplayInput(userInput);
        return userInput.equals("1");
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String generateAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            answer.append(computer.get(i));
        }
        return answer.toString();
    }

    public String getUserInput() {
        return Console.readLine();
    }

    public Map<String, Integer> gradeScore(String answer, String userInput) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int pos = answer.indexOf(userInput.charAt(i));
            if (pos == i) {
                strike += 1;
            } else if (pos >= 0) {
                ball += 1;
            }
        }
        Map<String, Integer> ret = new HashMap<>();
        ret.put("strike", strike);
        ret.put("ball", ball);
        return ret;
    }

    public void printScore(int strike, int ball) {
        if (ball >= 1 && strike >= 1) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball >= 1) {
            System.out.println(ball + "볼");
        } else if (strike >= 1) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    public void validateNumberInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        }
        for (int i=0 ; i<3 ; i++) {
            char c = input.charAt(i);
            if ('0' > c || '9' < c){
                throw new IllegalArgumentException("입력값의 범위가 잘못됐습니다.");
            }
        }
    }

    public void validateIfReplayInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
