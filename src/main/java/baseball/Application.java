package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static Map<Hint, Integer> hintMap;
    static List<Integer> answer;

    public static void main(String[] args) {
        System.out.println(Comment.STARTGAME);
        generateNewAnswer();

        while (true) {
            System.out.println(answer);
            System.out.print(Comment.INPUTNUMBER);
            String userInput = Console.readLine();
            validateInput(userInput, 3);

            calculateHint(answer, userInput);
            printHint();

            if(hintMap.get(Hint.STRIKE).equals(3)){
                System.out.println(Comment.ENDGAME);

                boolean isRestart = checkRestart();
                if (!isRestart) {
                    generateNewAnswer();
                    break;
                }
            }
        }
    }

    private static void generateNewAnswer() {
        answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static boolean checkRestart() {
        System.out.println(Comment.REGAME);
        String restartRely = Console.readLine();
        validateInput(restartRely, 1);
        if (restartRely.equals("1")) {
            return true;
        }
        return false;
    }

    private static void printHint() {
        Integer ballCount = hintMap.get(Hint.BALL);
        Integer strikeCount = hintMap.get(Hint.STRIKE);
        String hintStr = null;

        if (ballCount != 0 && strikeCount != 0) {
            hintStr = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        }
        if (ballCount != 0 && strikeCount == 0) {
            hintStr = String.format("%d볼", ballCount);
        }
        if (ballCount == 0 && strikeCount != 0) {
            hintStr = String.format("%d스트라이트", strikeCount);
        }
        if (hintStr == null) {
            hintStr = "낫싱";
        }
        System.out.println(hintStr);
    }

    private static void calculateHint(List<Integer> answer, String inputStr) {
        initializeHint();
        for (int i = 0; i < inputStr.length(); i++) {
            Integer target = Integer.parseInt(inputStr.charAt(i) + "");
            if (answer.contains(target) && answer.get(i).equals(target)) {
                Integer beforeCnt = hintMap.get(Hint.STRIKE);
                hintMap.put(Hint.STRIKE, ++beforeCnt);
            } else if (answer.contains(target)) {
                Integer beforeCnt = hintMap.get(Hint.BALL);
                hintMap.put(Hint.BALL, ++beforeCnt);
            }
        }
    }

    private static void initializeHint() {
        hintMap = new HashMap();
        hintMap.put(Hint.STRIKE, 0);
        hintMap.put(Hint.BALL, 0);
    }

    private static void validateInput(String input, int digit) {
        String tmpInput = input.trim();

        String numberOnlyRegex = "^[0-9]+$";
        boolean matches = tmpInput.matches(numberOnlyRegex);
        if (!matches) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if (tmpInput.length() != digit) {
            throw new IllegalArgumentException(digit + "자릿수를 입력해주세요.");
        }
    }
}

class Comment {
    final static String STARTGAME = "숫자 야구 게임을 시작합니다.";
    final static String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String REGAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String INPUTNUMBER = "숫자를 입력해주세요 : ";
}

enum Hint {
    STRIKE, BALL
}