package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

            if (hintMap.get(Hint.STRIKE).equals(3)) {
                System.out.println(Comment.ENDGAME);

                boolean isRestart = checkRestart();
                if (!isRestart) {
                    break;
                }
                generateNewAnswer();
            }
        }
    }

    private static void generateNewAnswer() {
        List<Integer> tmpAnswer = new ArrayList<>();
        while (tmpAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!tmpAnswer.contains(randomNumber)) {
                tmpAnswer.add(randomNumber);
            }
        }
        answer = tmpAnswer;
    }

    private static void validateInput(String input, int digit) {
        String tmpInput = input.trim();

        String numberOnlyRegex = "^[1-9]+$";
        boolean matches = tmpInput.matches(numberOnlyRegex);
        if (!matches) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }

        if (tmpInput.length() != digit) {
            throw new IllegalArgumentException(digit + "자릿수를 입력해주세요.");
        }
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

    private static boolean checkRestart() {
        System.out.println(Comment.REGAME);
        String restartRely = Console.readLine();
        validateInput(restartRely, 1);
        if (restartRely.equals("1")) {
            return true;
        }
        if (restartRely.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1 혹은 2 를 입력해주세요.");
    }

    private static void initializeHint() {
        hintMap = new HashMap();
        hintMap.put(Hint.STRIKE, 0);
        hintMap.put(Hint.BALL, 0);
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