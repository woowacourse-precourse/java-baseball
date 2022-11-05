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
        startApplication();

        while (true) {
            String userInput = requestUserInput();
            computeProcessing(userInput);

            boolean isCorrect = checkAnswer();
            boolean isRestart = checkRestart(isCorrect);
            if (isRestart) {
                initializeAnswer();
            } else if (isCorrect) {
                break;
            }
        }
    }

    private static void startApplication() {
        System.out.println(Comment.STARTGAME);
        initializeAnswer();
    }

    private static void initializeAnswer() {
        List<Integer> tmpAnswer = new ArrayList<>();
        final int ANSWER_SIZE = 3;
        final int START_NUM = 1;
        final int END_NUM = 9;

        while (tmpAnswer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!tmpAnswer.contains(randomNumber)) {
                tmpAnswer.add(randomNumber);
            }
        }
        answer = tmpAnswer;
    }

    private static String requestUserInput() {
        System.out.print(Comment.INPUTNUMBER);
        final int REQUEST_INPUT_DIGIT = 3;
        return validateInput(Console.readLine(), REQUEST_INPUT_DIGIT);
    }

    private static String validateInput(String input, int digit) {
        String tmpInput = input.trim();
        String numberOnlyRegex = "^[1-9]+$";
        boolean matches = tmpInput.matches(numberOnlyRegex);
        if (!matches) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
        if (tmpInput.length() != digit) {
            throw new IllegalArgumentException(digit + "자릿수를 입력해주세요.");
        }
        return tmpInput;
    }

    private static void computeProcessing(String userInput) {
        calculateHint(answer, userInput);
        printHint();
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
        hintMap = new HashMap<Hint, Integer>();
        hintMap.put(Hint.STRIKE, 0);
        hintMap.put(Hint.BALL, 0);
    }

    private static void printHint() {
        Integer ballCount = hintMap.get(Hint.BALL);
        Integer strikeCount = hintMap.get(Hint.STRIKE);
        String hintStr = null;

        if (ballCount != 0 && strikeCount != 0) {
            hintStr = ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if (ballCount != 0 && strikeCount == 0) {
            hintStr = ballCount + "볼";
        }
        if (ballCount == 0 && strikeCount != 0) {
            hintStr = strikeCount + "스트라이크";
        }
        if (hintStr == null) {
            hintStr = "낫싱";
        }

        System.out.println(hintStr);
    }

    private static boolean checkAnswer() {
        final int CORRECT_COUNT = 3;
        if (hintMap.get(Hint.STRIKE).equals(CORRECT_COUNT)) {
            System.out.println(Comment.ENDGAME);
            return true;
        }
        return false;
    }

    private static boolean checkRestart(boolean isCorrect) {
        if (isCorrect) {
            System.out.println(Comment.REGAME);

            final int REQUEST_INPUT_DIGIT = 1;
            String restartInput = validateInput(Console.readLine(), REQUEST_INPUT_DIGIT);

            if (restartInput.equals("1")) {
                return true;
            }
            if (restartInput.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("1 혹은 2 를 입력해주세요.");
        }
        return false;
    }

    enum Hint {
        STRIKE, BALL
    }

    static class Comment {
        final static String STARTGAME = "숫자 야구 게임을 시작합니다.";
        final static String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final static String REGAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        final static String INPUTNUMBER = "숫자를 입력해주세요 : ";
    }
}



